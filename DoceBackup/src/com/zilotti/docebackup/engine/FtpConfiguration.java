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

import com.zilotti.docebackup.Configuration;

public class FtpConfiguration implements Configuration {

	/**	Host name */
	private String host;
	
	/**	Port number */
	private String port;
	
	/**	Additional path */
	private String path;

	/**	User name */
	private String user;
	
	/**	Password */
	private String pass;
	
	/**	Passive mode? */
	private Boolean passiveMode;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Boolean getPassiveMode() {
		return passiveMode;
	}

	public void setPassiveMode(Boolean passiveMode) {
		this.passiveMode = passiveMode;
	}
}
