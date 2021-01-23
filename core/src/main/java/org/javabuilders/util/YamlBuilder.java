package org.javabuilders.util;

import java.util.ResourceBundle;

import org.javabuilders.BuildResult;
import org.javabuilders.Builder;
import org.javabuilders.BuilderConfig;

/**
 * Utility class to easily build YAML content from the Java-side, without an external YAML file.
 * Hack for the lack of embedded multi-line strings in Java...what would I give for Groovy's ''' syntax....
 * <p>Call the "_" method in multiple lines of Java code, e.g.
 * <code>
 * String yaml = new YamlBuilder().
 *        _("Yaml: ").
 *        _("    Second: Yaml").toString();
 *        
 * @author Jacek Furmankiewicz
 *
 */
public class YamlBuilder {

	private StringBuilder builder = new StringBuilder();
	
	/**
	 * @param root Constructor
	 */
	public YamlBuilder(String root) {
		__(root);
	}
	
	/**
	 * Main method to add
	 * @param yamlLine
	 * @return
	 */
	private YamlBuilder __(String yamlLine) {
		builder.append(yamlLine).append("\n");
		return this;
	}
	
	/**
	 * Insert nested
	 * @return This
	 */
	public YamlBuilder ____(String yamlLine) {
		nest();
		return __(yamlLine);
	}

	/**
	 * Insert nested
	 * @return This
	 */
	public YamlBuilder ______(String yamlLine) {
		nest();
		return ____(yamlLine);
	}

	/**
	 * Insert nested
	 * @return This
	 */
	public YamlBuilder ________(String yamlLine) {
		nest();
		return ______(yamlLine);
	}

	/**
	 * Insert nested
	 * @return This
	 */
	public YamlBuilder __________(String yamlLine) {
		nest();
		return ________(yamlLine);
	}

	/**
	 * Insert nested
	 * @return This
	 */
	public YamlBuilder ____________(String yamlLine) {
		nest();
		return __________(yamlLine);
	}

	/**
	 * Insert nested
	 * @return This
	 */
	public YamlBuilder ______________(String yamlLine) {
		nest();
		return ____________(yamlLine);
	}

	/**
	 * Insert nested
	 * @return This
	 */
	public YamlBuilder ________________(String yamlLine) {
		nest();
		return ______________(yamlLine);
	}

	/**
	 * Insert nested
	 * @return This
	 */
	public YamlBuilder __________________(String yamlLine) {
		nest();
		return ________________(yamlLine);
	}

	
	//adds a level of nesting
	private void nest() {
		builder.append("    ");
	}
	
	/**
	 * Starts a databinding node
	 * @return This
	 */
	public YamlBuilder bind() {
		builder.append("bind:\n");
		return this;
	}
	
	/**
	 * Starts a validation node
	 * @return This
	 */
	public YamlBuilder validate() {
		builder.append("validate:\n");
		return this;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return builder.toString();
	}
	
	/**
	 * Clears the text
	 */
	public void clear() {
		builder.setLength(0);
	}
	
	/**
	 * Executes a build
	 * @param config
	 * @param caller
	 * @param bundles
	 * @return
	 */
	public BuildResult build(BuilderConfig config, Object caller, ResourceBundle... bundles) {
		return Builder.buildFromString(config, caller, toString(), bundles);
	}
	
}
