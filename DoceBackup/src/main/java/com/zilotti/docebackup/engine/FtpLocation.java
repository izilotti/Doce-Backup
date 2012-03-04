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
package com.zilotti.docebackup.engine;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.zilotti.docebackup.Location;
import com.zilotti.docebackup.tree.Node;
import com.zilotti.docebackup.tree.NodeInfo;

public class FtpLocation<F extends FtpConfiguration> implements Location<F> {

	public Node<NodeInfo> loadTree() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setConfiguration(F configuration) {
		// TODO Auto-generated method stub
		
	}

	public F getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFile(FileOutputStream fos) {
		// TODO Auto-generated method stub
		
	}

	public void removeFile(FileOutputStream fos) {
		// TODO Auto-generated method stub
		
	}

	public void replaceFile(FileOutputStream fos) {
		// TODO Auto-generated method stub
		
	}

	public FileInputStream readFile(String path, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
