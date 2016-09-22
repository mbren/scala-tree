/**
This Tree class implements an N-ary tree which is a rooted tree in which each node has no more than n children.
*/

class Tree {

  sealed abstract class N_aryTree

  case class Leaf(value: String) extends N_aryTree

  case class Node(value: String, n: N_aryTree*) extends N_aryTree

  //Search for a node in a tree.
  //Return the value of the node if it exists, and the empty string, "", if not.
  //For example, if given "g" and a tree contains a node "g", it should return the string "g".
  //This implementation has a best and worst case complexity of O(n) because the whole tree is traversed every time,
  //even if the element is found right away.
  def searcher(key: String, tree: N_aryTree): String = {
    if (countOfInstances(key, tree) > 0) key else ""
  }

  //Count the number of times the key appears in the tree.
  def countOfInstances(key: String, tree: N_aryTree): Int = {

    tree match {
      case Leaf(str) => {
        //println("Key is: " + key + " Str is: " + str)
        if (str == key) 1 else 0
      }
      case Node(str, nodes@_*) if (str == key) => {
        //Each node may have a different number of children so use @_*.
        //println("Key is: " + key + " Str is: " + str)
        //Only increment the count if the node matches
        1 + nodes.map(countOfInstances(key, _)).sum
      }
      case Node(str, nodes@_*) if (str != key) => {
        //println("Key is: " + key + " Str is: " + str)
        //The key doesn't match so don't increment the count, just continue the recursion.
        nodes.map(countOfInstances(key, _)).sum
      }
    }
  }
  //Please refer to the TreeSpec.scala file for the implementation of the tests.
}
