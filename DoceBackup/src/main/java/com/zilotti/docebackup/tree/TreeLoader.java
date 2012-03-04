/*
 * Copyright 2012 Ivan Zilotti Alencar <ialencar@zilotti.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zilotti.docebackup.tree;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class TreeLoader {

	private static final String STARTING_PATH = "D:\\MP3-Organized"; //"D:\\MP3-Organized"; //"D:\\_Personal\\Ivan\\Projects\\BlazingFastBackup\\Test Folder";
	
	private static AccumulatedSizeCalculator accsc = new AccumulatedSizeCalculator();
	
	public static void main(String[] args) {
		TreeLoader tt = new TreeLoader();
		Node<FileInfo> rootNode = tt.getTree(STARTING_PATH);
		tt.printTree(rootNode);
		System.out.println("done");
	}

	/**
	 * Prints the tree.
	 * 
	 * @param rootNode Tree's root node.
	 */
	private void printTree(Node<FileInfo> rootNode) {
		for(Node<FileInfo> node : rootNode.getChildren()) {
			System.out.println("["+ humanReadableByteCount(node.getPayload().getAccumulatedSize(), true) +"]"+ node.getPayload().getFile().getPath());
			if(node.getPayload().getFile().isDirectory()) {
				printTree(node);
			}
		}
	}
	
	
	/**
	 * Loads the tree representing the directory structure under the starting directory path specified.
	 * 
	 * @param startingDirPath Base directory.
	 * @return A Node<File> corresponding to the tree's root node.
	 */
	private Node<FileInfo> getTree(String startingDirPath) {
		Node<FileInfo> rootNode = new Node<FileInfo>(new FileInfo(new File(startingDirPath)));
		rootNode.setChildren(this.getSubTree(rootNode));
		accsc.waitWorkersToFinish();
		return rootNode;
	}
	
	
	/**
	 * Gets all sub-trees under the node passed. 
	 * 
	 * @param dirNode A directory tree node.
	 * @return A list of Nodes<File> containing the whole sub-tree.
	 */
	private List<Node<FileInfo>> getSubTree(Node<FileInfo> dirNode) {
		List<Node<FileInfo>> children = new LinkedList<Node<FileInfo>>();
		for(File entry : getFilesDirsDir(dirNode.getPayload().getFile())) {
			Node<FileInfo> node = new Node<FileInfo>(new FileInfo(new File(entry.getPath())));
			node.setParent(dirNode);
			children.add(node);
			if(entry.isDirectory()) {
				node.setChildren(getSubTree(node));
			} else {
				node.getPayload().setAccumulatedSize(entry.length()); // Set file size to node
				accsc.processLeaf(node);
			}
		}
		return children;
	}
	
	/**
	 * Obtains files and directories under the specified directory.
	 * 
	 * @param dir
	 * @return
	 */
	private List<File> getFilesDirsDir(File dir) {
		List<File> filesDirs = new LinkedList<File>();
		for(File f : dir.listFiles())
			filesDirs.add(new File(f.getPath()));
		return filesDirs;
	}
	
	
	static class AccumulatedSizeCalculator {
		
		private int THREAD_POOL_SIZE = 5;
		ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(THREAD_POOL_SIZE);
		private long workCounter = 0L;
		
		class Worker implements Runnable {

			
			/** The leaf node to be propagated by the worker */
			private Node<FileInfo> leafNode;
			
			/** Size of the leaf node */
			private long leafNodeSize = 0;
			
			public Worker(Node<FileInfo> aLeafNode) {
				this.leafNode = aLeafNode;
			}

			/**
			 * Traverses the three from leaf thru root carrying the size of 
			 * the file to its predecessor directories.
			 * 
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				this.leafNodeSize = this.leafNode.getPayload().getAccumulatedSize();
				this.carryLeafSizeUp(this.leafNode);
				decrementWork();
			}
			
			/**
			 * Recursively propagates the size of a file (leaf) through
			 * the predecessor directories up to the root node. 
			 * 
			 * @param node
			 */
			private void carryLeafSizeUp(Node<FileInfo> node) {
				if(node.getParent() != null) {
					Node<FileInfo> parentNode = node.getParent();
					long currentAccumulatedSize = parentNode.getPayload().getAccumulatedSize();
					parentNode.getPayload().setAccumulatedSize(currentAccumulatedSize + this.leafNodeSize);
					carryLeafSizeUp(parentNode);
				}
			}
		}
		
		/**
		 * Processes a leaf node (file).
		 * 
		 * @param leafNode
		 */
		public void processLeaf(Node<FileInfo> leafNode) {
			incrementWork();
			Worker worker = new Worker(leafNode);
			executor.execute(worker);
		}
		
		private synchronized void incrementWork() {
			workCounter++;
		}
		
		private synchronized void decrementWork() {
			workCounter--;
		}
		
		public void waitWorkersToFinish() {
			System.out.println("Waiting for workers to finish...");
			while(workCounter != 0) {
				System.out.println("Polling..."+ workCounter);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			executor.shutdown();
		}
	}
	
	/**
	 * XXX: Use apache commons
	 * @param bytes
	 * @param si
	 * @return
	 */
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	
}

