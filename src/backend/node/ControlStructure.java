package backend.node;
import java.util.List;

import backend.node.*;

/**
 * @author loganrooper
 *
 */
public abstract class ControlStructure extends Node{
	protected ControlStructure() {
		super();
	}

	protected abstract Node run(List<Node> nl, Executor executor);
}