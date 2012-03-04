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
package com.zilotti.docebackup;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.zilotti.docebackup.tree.Node;
import com.zilotti.docebackup.tree.NodeInfo;

/**
 * @author Ivan Zilotti Alencar
 *
 * @param <C> Type of the location Configuration.
 */
public interface Location<C extends Configuration> {
	
	/**
	 * Loads a comparable tree of NodeInfos.
	 * @return
	 */
	Node<NodeInfo> loadTree();
	
	/**
	 * Sets the configuration of this location.
	 * @param configuration
	 */
	void setConfiguration(C configuration);
	
	/**
	 * Gets the configuration of this location.
	 * @return
	 */
	C getConfiguration();

	/**
	 * Adds a file to this location
	 * @param fileInfo
	 */
	void addFile(FileOutputStream fos);
	
	void removeFile(FileOutputStream fos);
	
	void replaceFile(FileOutputStream fos);
	
	FileInputStream readFile(String path, String fileName); 
}
