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

import com.zilotti.docebackup.Location;

public class DiskLocation<D extends DiskConfiguration> implements Location<D> {

	/**
	 * @see com.zilotti.docebackup.Location#setConfiguration(com.zilotti.docebackup.Configuration)
	 */
	@Override
	public void setConfiguration(D configuration) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see com.zilotti.docebackup.Location#getConfiguration()
	 */
	@Override
	public D getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}