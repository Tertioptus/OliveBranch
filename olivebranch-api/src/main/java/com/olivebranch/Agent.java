/*
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.olivebranch;

/**
 * An Agent represents a user performing some activity via a graphical user
 * interface.
 * 
 * @author Benjamin F. Paige III
 * @version 1.0
 * @since 1.0
 */
public interface Agent<T> {

	/**
	 * Directs agent to a particular page within the application's site.
	 * 
	 * @param string
	 * 
	 * @return Returns calling Agent<T>
	 */
	Agent<T> goTo(String string);

	/**
	 * Commands agent to click on a requested element.
	 * 
	 * @param selector
	 * 
	 * @return Returns calling Agent<T>
	 */
	Agent<T> click(Content<T> content);

	/**
	 * Tells agent to input text within the requested element.
	 * 
	 * @param selector
	 * @param keys
	 * 
	 * @return Returns calling Agent<T>
	 */
	Agent<T> type(Content<T> content, CharSequence keys);

	/**
	 * Clears data out of the requested element. Primarily for textual form
	 * fields.
	 * 
	 * @param selector
	 * 
	 * @return Returns calling Agent<T>
	 */
	Agent<T> clear(Content<T> content);

	/**
	 * Selects option from specified select box content.
	 * 
	 * @param content
	 *            select box
	 * @param option
	 *            select box option
	 * 
	 * @return Returns calling Agent<T>
	 */
	Agent<T> select(Content<T> selectBox, String option);

	/**
	 * Requests agent to wait for previous action to complete for a specified
	 * amount of time.
	 * 
	 * @param time
	 *            The amount of time for agent to wait.
	 * 
	 * @return Returns calling Agent<T>
	 */
	Agent<T> wait(Time time);

	/**
	 * Reports availability of requested element.
	 * 
	 * @param selector
	 * @return availability of requested element.
	 */
	boolean verify(Content<T> content);
	
	/**
	 * Read the contents of a Content<T> instance.
	 * 
	 * @param content
	 * @return contents of Content<T>
	 */
	String read(Content<T> content);

	/**
	 * Agent<T> reports on one aspect of user session
	 * 
	 * @param on
	 */
	String report(On on);

	/**
	 * Record the current rendition of a GUIs resource.
	 * 
	 * @param imageOf
	 *            An enumerator designating the type of resource
	 * @return location of captured file
	 */
	String capture(ImageOf imageOf);

	/**
	 * End session.
	 */
	void quit();
}
