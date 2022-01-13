// TypeEnv.java
// Type environment for S
import java.util.*;

// <id, type> 
class Entry {
   Identifier id;
   Type type;
   
   Entry (Identifier id, Type t) {
     this.id = id;
     this.type = t;
   }
   
}

class TypeEnv extends Stack<Entry> {
    public TypeEnv() { }
    
    public TypeEnv(Identifier id, Type t) {
        push(id, t);
    }
    
    public TypeEnv push(Identifier id, Type t) {
        super.push(new Entry(id, t));
	return this;
    }
    
    
    // (1) Contatins Function Implementation
    public boolean contain (Identifier v) {
       // Contains Implementation
    	if (this.empty()){ //stack이 비었을 경우
    		return false; //false return
    	}
    	
    	for (int i = this.size()-1; i>=0; i--) {	//for문으로 stack 전체 검사
    		Entry entry = this.get(i); //Entry 객체 생성하여 stack의 entry 받아옴
			if(entry.id.equals(v)) { //entry의 id가 v와 같다면
				return true; //contain은 true
			}
		}
    	
    	return false;
    }

    // (2) Get Function Implementation
    public Type get (Identifier v) {
        // Get Implementation
    	
    	for (int i = this.size()-1; i>=0; i--) {	//for문으로 stack 전체 검사
    		Entry entry = this.get(i); //Entry 객체 생성하여 stack의 entry 받아옴
			if(entry.id.equals(v)) {//entry의 id가 v와 같다면
				return entry.type; //해당 entry의 type return
			}
		}
		return v.type;

    }
}