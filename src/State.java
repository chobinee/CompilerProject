import java.util.*;
// State as stack 

// <id, val> 
class Pair {
   Identifier id;
   Value val;
   
   Pair (Identifier id, Value v) {
     this.id = id;
     this.val = v;
   }
}

class State extends Stack<Pair> {
    public State( ) { }
    
    public State(Identifier id, Value val) {
        push(id, val);
    }

    // (1) Push function Implementation
    public State push(Identifier id, Value val) {
    	// Push Implementation
    	Pair pair = new Pair(id, val); //id와 val을 파라미터로 받아서 Pair의 객체 생성
    	this.push(pair);
    	return this;
    }

    // (2) Pop function Implementation (Optional)
    public Pair pop() {
    	// Pop Implementation (Optional)
    	
    	Pair pair = this.get(this.size()-1); //전 객체 get
    	this.remove(this.size()-1); //삭제 후
    	return pair; //받은 객체 리턴
    }
    
    // (3) Lookup function Implementation
    public int lookup (Identifier v) {
       // Lookup Implementation
    	
    	for (int i = this.size()-1; i>=0; i--) {	//for문 통해 stack 전체 검사
    		Pair pair = this.get(i); //Pair 객체 생성하여 stack의 pair 받아옴
			if(pair.id.equals(v)) { //v와 같으면
				return i; //해당 번호 return
			}
		}
    	return -1; //없을 경우 오류 발생(-1은 array index에서 존재하지 않으므로)
    }

    // (4) Set Function Implementation
    public State set(Identifier id, Value val) {
    	// Set Implementation
    	int index = this.lookup(id); //lookup을 통해 index 찾기
    	Pair pair = new Pair(id, val); //id와 val 값을 파라미터로 받아 Pair 객체 생성
    	this.set(index, pair); //해당 index의 Pair을 새로운 값으로 setting
    	return this;


    }
    
    // (5) Get Function Implementation
    public Value get (Identifier id) {
    	// Get Implementation
    	for (int i = this.size()-1; i>=0; i--) {	 //for문 통해 stack 전체 검사
    		Pair pair = this.get(i); //Pair 객체 생성하여 stack의 pair 받아옴
			if(pair.id.equals(id)) { //id와 같으면
				return pair.val; //해당 id의 val return
			}
		}
    	return null; //아니면 null return
    	

    }

}