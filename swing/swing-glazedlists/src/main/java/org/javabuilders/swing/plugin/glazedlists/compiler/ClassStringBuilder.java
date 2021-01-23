package org.javabuilders.swing.plugin.glazedlists.compiler;

import java.lang.StringBuilder;

/**
 * Build's a class's code
 * @author jacek
 *
 */
public class ClassStringBuilder  {

	private StringBuilder bld = new StringBuilder();
	
	/**
	 * Adds a line at 1 level of indentation
	 */
	public ClassStringBuilder __(String template, Object...params) {
		return add(0,template,params);
	}
	
	public ClassStringBuilder ____(String template, Object...params) {
		return add(1,template,params);
	}
	
	public ClassStringBuilder ______(String template, Object...params) {
		return add(2,template,params);
	}
	
	public ClassStringBuilder ________(String template, Object...params) {
		return add(3,template,params);
	}
	
	public ClassStringBuilder __________(String template, Object...params) {
		return add(4,template,params);
	}
	
	public ClassStringBuilder ____________(String template, Object...params) {
		return add(5,template,params);
	}
	
	private ClassStringBuilder add(int level, String template, Object...params) {
		for(int i = 0; i < level;i++) {
			bld.append("\t");
		}
		bld.append(String.format(template, params)).append("\n");
		return this;
	}
	
	@Override
	public String toString() {
		return bld.toString();
	}
}
