
package doubletest;


public class DoubleLinkList<E> {

    public class DNode<E> {

        protected E element;
        protected DNode<E> next, prev;

        public DNode(E e, DNode next, DNode prev) {
            element = e;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public DNode<E> getNext() {
            return next;
        }

        public DNode<E> getPrev() {
            return prev;
        }

        public void setElement(E newElement) {
            element = newElement;
        }

        public void setNext(DNode newNext) {
            next = newNext;
        }

        public void setPrev(DNode newPrev) {
            prev = newPrev;
        }
    } // end of DNode class
    protected DNode<E> header;
    protected DNode<E> trailer;
    protected long size;

    // constructs a new Empty list..
    public DoubleLinkList() {
        header = new DNode(null, null, null);
        trailer = new DNode(null, null, null);
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    public long size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E First() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    public E Last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public void addBetween(E e, DNode<E> predecessor, DNode<E> sucessor) {
        DNode<E> newNode = new DNode(e, sucessor, predecessor);
        predecessor.setNext(newNode);
        sucessor.setPrev(newNode);
        size++;
    }

    public E remove(DNode<E> Node) {
        DNode<E> pre = Node.getPrev();
        DNode<E> post = Node.getNext();
        pre.setNext(post);
        post.setPrev(pre);
        size--;
        return Node.getElement();
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return this.remove(header.getNext());
    }

    public E removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.remove(trailer.getPrev());
    }

    public void fun(E e) {

        DNode<E> T = header.getNext();

        while (T != trailer) {

            if ((Integer) T.getElement() % 2 == 0) {
                addBetween(e, T, T.getNext());
            }
            System.out.println("{" + T.getElement() + "}");

            T = T.getNext();

        }

    }

    public void print() {
        DNode<E> T = header.getNext();

        while (T != trailer) {
            System.out.println(T.getElement());
            T = T.getNext();

        }

    }

    public void even() {

        DNode<E> T = header.getNext();
        int sum = 0;
        while (T != trailer) {
            if ((Integer) T.getElement() % 2 == 0) {
                sum += (Integer) T.getElement();
                System.out.print(T.getElement() + "   ");
            }

            T = T.getNext();
        }
        System.out.println();
        System.out.println("the sum: " + sum);

    }

    public void max() {
        DNode<E> T = header.getNext();
        int max = (Integer) T.getElement();

        while (T != trailer) {

            if (max < (Integer) T.getElement()) {
                max = (Integer) T.getElement();
            }

            T = T.getNext();
        }
        System.out.println("the max number: " + max);

    }

    public void makeunique() {

        DNode<E> p;
        DNode<E> T = header.getNext();
        
        while (T!=trailer){
            E data1 = T.getElement();
            p = T.getNext();
            
            while (p != null){
                E data2 = p.getElement();
                if(data1.equals(data2))
                    remove(p);
                p =p.getNext();
            }
            
            T = T.getNext();
            
        }

    }
    
    public void Method1( ){


       DNode T = header.getNext();


       int counter=0;


  while (T.getNext()!= null) {


  if ( counter%2 ==0)


   System.out.print(T.getElement() );


          T=T.getNext();


          counter++;                         


            }


}
    
    
}
