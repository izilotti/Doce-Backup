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

/**
 * File information needed by the balancing algorithm. 
 * 
 * @author Ivan Zilotti Alencar
 */
public class FileInfo extends NodeInfo {

	/** Directory or file */
	private File file;
	
	/** Accumulated size */
	private long accumulatedSize = 0L;
	
	public FileInfo(File file) {
		super();
		this.file = file;
	}

	public FileInfo() {
		super();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public long getAccumulatedSize() {
		return accumulatedSize;
	}

	public synchronized void setAccumulatedSize(long accumulatedSize) {
		this.accumulatedSize = accumulatedSize;
	}
}
