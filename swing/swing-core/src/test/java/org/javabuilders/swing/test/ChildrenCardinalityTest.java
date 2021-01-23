package org.javabuilders.swing.test;

import org.javabuilders.ChildrenCardinalityException;
import org.javabuilders.swing.util.SwingYamlBuilder;
import org.junit.Test;

/**
 * Swing builder children cardinalities testing
 * @author Jacek Furmankiewicz
 *
 */
public class ChildrenCardinalityTest {

	@Test
	public void testJFrameSimple() {
		new SwingYamlBuilder("JFrame()") {{
		}}.build(this);
	}

	@Test(expected=ChildrenCardinalityException.class)
	public void testJFrameInvalidObject() {
		new SwingYamlBuilder("JFrame():") {{
			____("- TableColumn()");
		}}.build(this);
	}
	
	@Test
	public void testScrollPane() {
		new SwingYamlBuilder("JScrollPane():") {{
			____("JPanel()");
		}}.build(this);
	}

	@Test(expected=ChildrenCardinalityException.class)
	public void testScrollPaneInvalidList() {
		new SwingYamlBuilder("JScrollPane():") {{
			____("- JPanel()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testScrollPaneInvalidListMoreThanOne() {
		new SwingYamlBuilder("JScrollPane():") {{
			____("- JPanel()");
			____("- JPanel()");
		}}.build(this);
	}

	@Test
	public void testJSplitPane() {
		new SwingYamlBuilder("JSplitPane()") {{
		}}.build(this);
	}

	@Test
	public void testJSplitPaneWithOne() {
		new SwingYamlBuilder("JSplitPane():") {{
			____("- JPanel()");
		}}.build(this);
	}

	@Test
	public void testJSplitPaneWithTwo() {
		new SwingYamlBuilder("JSplitPane():") {{
			____("- JPanel()");
			____("- JPanel()");
		}}.build(this);
		
	}

	@Test(expected=ChildrenCardinalityException.class)	
	public void testJSplitPaneWithInvalidThree() {
		new SwingYamlBuilder("JSplitPane():") {{
			____("- JPanel()");
			____("- JPanel()");
			____("- JPanel()");
		}}.build(this);
		
	}

	@Test(expected=ChildrenCardinalityException.class)	
	public void testJSplitPaneWithInvalidChild() {
		new SwingYamlBuilder("JSplitPane():") {{
			____("JPanel()");
		}}.build(this);
	}
	
	@Test
	public void testJPanel() {
		new SwingYamlBuilder("JPanel()") {{
		}}.build(this);
	}

	@Test
	public void testJPanelWith1() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JButton()");
		}}.build(this);
	}

	@Test
	public void testJPanelWith2() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JButton()");
			____("- JButton()");
		}}.build(this);
	}
	
	@Test
	public void testJPanelWith3() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JButton()");
			____("- JButton()");
			____("- JButton()");
		}}.build(this);
	}

	@Test(expected=ChildrenCardinalityException.class)
	public void testJPanelWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("JButton()");
		}}.build(this);
	}

	@Test
	public void testJLabel() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JLabel()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testJLabelWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JLabel():");
			______("- JLabel():");
		}}.build(this);
	}
	
	@Test
	public void testJButton() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JButton()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testJButtonWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JButton():");
			______("- JLabel():");
		}}.build(this);
	}

	@Test
	public void testJTextField() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JTextField()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testJTextFieldWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JTextField():");
			______("- JLabel():");
		}}.build(this);
	}

	@Test
	public void testJRadioButton() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JRadioButton()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testJRadioButtonWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JRadioButton():");
			______("- JLabel():");
		}}.build(this);
	}

	@Test
	public void testJCheckBox() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JCheckBox()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testJCheckBoxWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JCheckBox():");
			______("- JLabel():");
		}}.build(this);
	}

	@Test
	public void testJList() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JList()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testJListWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JList():");
			______("- JLabel():");
		}}.build(this);
	}

	@Test
	public void testJProgressBar() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JProgressBar()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testJProgressBarWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JProgressBar():");
			______("- JLabel():");
		}}.build(this);
	}

	@Test
	public void testJSpinner() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JSpinner()");
		}}.build(this);
	}
	
	@Test(expected=ChildrenCardinalityException.class)
	public void testJSpinnerWithInvalidChild() {
		new SwingYamlBuilder("JPanel():") {{
			____("- JSpinner():");
			______("- JLabel():");
		}}.build(this);
	}

}
