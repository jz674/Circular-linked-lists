package LinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import LinkedList.CLL.Node;

public class CLLTest {

	@Test
	public void testConstructor() {
		CLL<Integer> b= new CLL<Integer>();
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringRev());
		assertEquals(0, b.size());
		
		// check that the head is null
		assertEquals(null, b.head);
	} 

	@Test
	/**test append method*/
	public void testAppend() {
		CLL<Integer> c= new CLL<Integer>();
		c.append(5);
		assertEquals("[5]", c.toString());
		assertEquals("[5]", c.toStringRev());
		assertEquals(1, c.size());

		c.append(1);
		assertEquals("[5, 1]", c.toString());
		assertEquals("[1, 5]", c.toStringRev());
		assertEquals(2, c.size()); 

		c.append(2);
		assertEquals("[5, 1, 2]", c.toString());
		assertEquals("[2, 1, 5]", c.toStringRev());
		assertEquals(3, c.size()); 

		c.append(3);
		assertEquals("[5, 1, 2, 3]", c.toString());
		assertEquals("[3, 2, 1, 5]", c.toStringRev());
		assertEquals(4, c.size()); 
	}

	@Test
	/**test prepend method*/
	public void testPrepend() {
		CLL<Integer> c= new CLL<Integer>();
		c.prepend(5);
		assertEquals("[5]", c.toString());
		assertEquals("[5]", c.toStringRev());
		assertEquals(1, c.size());

		c.prepend(1);
		assertEquals("[1, 5]", c.toString());
		assertEquals("[5, 1]", c.toStringRev());
		assertEquals(2, c.size());

		c.prepend(2);
		assertEquals("[2, 1, 5]", c.toString());
		assertEquals("[5, 1, 2]", c.toStringRev());
		assertEquals(3, c.size());

		c.prepend(3);
		assertEquals("[3, 2, 1, 5]", c.toString());
		assertEquals("[5, 1, 2, 3]", c.toStringRev());
		assertEquals(4, c.size());
	}

	@Test
	/**test getNode method*/
	public void testGetNode() {
		CLL<Integer> c= new CLL<Integer>();
		c.append(2);
		c.append(4);
		c.append(6);
		c.append(8);
		c.append(10);
		c.append(12);
		c.append(14);
		assertEquals(c.head, c.getNode(0));
		//when h is near the front of the list
		assertEquals(c.head.succ, c.getNode(1));
		int h = c.getNode(1).value; //not really needed
		assertEquals(4,h);
		//when h is near the end of the list
		h = c.getNode(5).value;
		assertEquals(12,h);	
		
		//when it throws the error bc h is wrong
		try{
			c.getNode(-1);
			fail();
		} catch(IndexOutOfBoundsException e){ }
		try{
			c.getNode(20);
			fail();
		} catch(IndexOutOfBoundsException e){ }
	}

	@Test
	/**test insertAfter method*/
	public void insertAfter() {
		CLL<Integer> c= new CLL<Integer>();
		c.append(2);
		CLL<Integer>.Node n = c.getNode(0);
		c.insertAfter(5,n);
		assertEquals("[2, 5]", c.toString());
		assertEquals("[5, 2]", c.toStringRev());
		assertEquals(2, c.size());

	}

	@Test
	/**test remove method*/
	public void remove() {
		
		//when node size == 1
		CLL<Integer> c1 = new CLL<Integer>();
		c1.append(1);
		CLL<Integer>.Node n2 = c1.getNode(0);
		c1.remove(n2);
		assertEquals("[]", c1.toString());
		assertEquals("[]", c1.toString());



		//regular test
		CLL<Integer> c= new CLL<Integer>();
		c.append(2);
		c.append(3);
		c.append(4);
		CLL<Integer>.Node n = c.getNode(0);
		c.remove(n);
		assertEquals("[3, 4]", c.toString());
		assertEquals("[4, 3]", c.toStringRev());
		assertEquals(2, c.size());
		
		
		//when node size is long af
		c.append(2);
		c.append(3);
		c.append(4);
		c.append(2);
		c.append(3);
		c.append(4);
		CLL<Integer>.Node n1 = c.getNode(7);
		c.remove(n1);
		assertEquals("[3, 4, 2, 3, 4, 2, 3]", c.toString());
		assertEquals("[3, 2, 4, 3, 2, 4, 3]", c.toStringRev());
		assertEquals(7, c.size());
		

		







	}

}
