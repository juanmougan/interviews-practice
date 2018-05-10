class Graph<T>(var vertexes: Set<Node<T>>) {
    data class Node<T>(val data: T, val neighbours: List<Node<T>>)

    /*
    Pick a starting node and push all its adjacent nodes into a stack.
    Pop a node from stack to select the next node to visit and push all its adjacent nodes into a stack.
    Repeat this process until the stack is empty. However, ensure that the nodes that are visited are marked. This will prevent you from visiting the same node more than once.
    */

    /*
    DFS-recursive(G, s):
            mark s as visited
            for all neighbours w of s in Graph G:
                if w is not visited:
                    DFS-recursive(G, w)
    */

    // Mark as visited -> add the Node to a Set?

}
