package com.wanghuanming.suffixtree

import scala.collection.mutable

/**
  * Created by ming on 17-4-7.
  */
class TreeNode(var seq: RangeSubString) extends Serializable {

  lazy val children = new mutable.HashMap[Char, TreeNode]
  lazy val terminals = new mutable.ArrayBuffer[RangeSubString]

  def hasChild(ch: Char) = children.contains(ch)

  def childNode(ch: Char): TreeNode = children(ch)

  def addChild(str: RangeSubString): Unit = {
    assert(!children.contains(str.head))
    children += str.head -> new TreeNode(str)
  }

  def addChild(node: TreeNode): Unit = {
    assert(!children.contains(node.seq.head))
    children += node.seq.head -> node
  }

  def updateChild(ch: Char, node: TreeNode): Unit = {
    assert(ch == node.seq.head && children.contains(ch))
    children.update(ch, node)
  }

  def addTerminal(str: RangeSubString): Unit = {
    terminals += str
  }

  override def toString: String = {
    s"TreeNode($seq)"
  }
}
