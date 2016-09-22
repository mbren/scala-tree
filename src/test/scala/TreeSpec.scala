import org.scalatest.{FunSpec, Matchers}

//Note: Add ScalaTest as a dependency in the build.sbt file by adding:
//libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
//Configure your project to use "auto-import".

class TreeSpec extends FunSpec with Matchers {

  //Create an n-ary tree for testing that looks like this:
  //               a
  //              / \
  //             b   c
  //            /|\   \
  //           d e f   g
  //                   |
  //                   h
  val t = new Tree
  val testTree = t.Node(
    "a",
    t.Node(
      "b",
      t.Leaf("d"), t.Leaf("e"), t.Leaf("f")
    ),
    t.Node(
      "c",
      t.Node(
        "g",
        t.Leaf("h")
      )
    )
  )

  describe("Print the testTree structure") {
    println("The test tree is: " + testTree.toString)
  }

  describe("Find the element, a, in the N-ary Tree") {
    it("Find a") {
      assert(t.searcher("a", testTree) === "a")
    }
  }

  describe("Find the element, b, in the N-ary Tree") {
    it("Find b") {
      assert(t.searcher("b", testTree) === "b")
    }
  }

  describe("Find the element, h, in the N-ary Tree") {
    it("Find h") {
      assert(t.searcher("h", testTree) === "h")
    }
  }

  describe("Searching for an element that doesn't exist should return an empty string.") {
    it("Find nope") {
      assert(t.searcher("nope", testTree) === "")
    }
  }
}

