package GUI.tabs;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tabs {

	public Node setTab(){

		TabPane tabPane = new TabPane();
		Tab tab = new Tab();
		tab.setText("Turtle Workspace");
		tab.setContent(new Rectangle(800,580, Color.WHITE));
		tab.setClosable(true);
		tabPane.getTabs().add(tab);

		return tabPane;
	}
}
