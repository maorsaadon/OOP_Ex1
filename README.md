# Observer

The observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.    
In this program we will add some more functionality to the UndoableStringBuilder which based on StringBuilder with support for the undo().  
We will add an option to organize a group of recipients of updates on the status of UndoableStringBuilder and send all updates to it in real time.  
We will add tracking of the size of the Heap object in the Test class.

In order for our run times to be efficient we used HashSet. HashSet is a collection that stores a set of elements. It is implemented using a hash table, which allows for fast insertion, deletion, and lookup of elements. HashSet does not allow duplicate elements, and it does not maintain the insertion order of the elements.

## The Main Interface  
1.Sender      
2.Member   

### 1.Sender 

This interface describes the Observerable (update sender).
This interface hold the function that the GroupAdmin actualize.

#### Declaration

```java
import observer.Sender;  

//methods to register and unregister observers
void register(Member obj);
void unregister(Member obj) throws Exception;

//Inserts the string into this character sequence.
void insert(int offset, String obj);

// Appends the specified string to this character sequence.
void append(String obj);

// Removes the characters in a substring of this sequence.
void delete(int start, int end);

// Erases the last change done to the document, reverting it to an older state. 
void undo();
```

### 2.Member

This interface describes the Observer (update reciever).
This interface hold the function that ConcreteMember actualize.

#### Declaration

```java
import observer.Member;

public void update(UndoableStringBuilder usb);
```

## The Main Classes
 
1.UndoableStringBuilder         
2.AdminGroup    
3.ConcreteMember    

### 1.UndoableStringBuilder  

This class use the StringBuilder class methods to make our UndoableStringBuilder class.     
We crate methods using the methods that StringBuilder have.    
The idea of this class is to give us the latest thing that the object had.      
This UndoableStringBuilder class take a StringBuilder and give us the perv word or sentence that this StringBuilder had with using stack.  

### 2.GroupAdmin 
   
This class actualize the functions of the Sender that describe the Observerbale, and we also have function that notify the observers and function to return the size of the member.  
GroupAdmin contains the state pool (UdoableStringBuilder) and also contains an HashSet that holds all customers who should receive updates on any changes made to the state pool , the class has a constructor that builds a GroupAdmin from UdoableStringBuilder and HashSet<Member>.
In every function we call notify() in order to update all the member about every change that has been made to the UndoableStringBuilder.  

```java  
notify(HashSet<Member>);
```

#### Usage

```java  
import observer.GroupAdmin;  

//Add the Member to the GroupAdmin.  
GroupAdmin.register(Member);

//Remove the Member to the GroupAdmin.  
GroupAdmin.unregister(Member);

//Inserts the string into this character sequence.  
GroupAdmin.insert(int,String);

//Appends the specified String to this  character sequence.  
GroupAdmin.append(String);

//Removes the characters in a substring of this sequence.  
GroupAdmin.delete(int, int);

//Performs a return to the previous state.  
GroupAdmin.undo();

//Return the number of the members
GroupAdmin.getSizeMember();
```


### 3.ConcreteMember
   
This class actualize the functions of the Member that describe the Observer, and we also have function to getData().  
ConcreteMember contains String that update every time the GroupAdmin notify about a change in other word its a copy (copy sallow) of the UndoableStringBuilder

#### Usage

```java
import observer.ConcreteMember;

//Update the String that ConcreteMember hold according to change of the UndoableStringBuilder of the GroupAdmin
ConcreteMember.update(UndoableStringBuilder);

//Return the String that ConcreteMember hold
ConcreteMember.getData();
```
## Download & run the program

In order to run this project follow this steps:  
  1. Download zip from our reposetory : push on code -> Download zip.  
  2. Extract all on yor computer.  
  3. Open a new java project.  
  4. Open the file in your java's workspace.  
  5. Press on pom.xml.  
  6. Press ok.  
  7. Run the project.  
