package org.knallgrau.tests;

import org.knallgrau.utils.textcat.TextCategorizer;

import junit.framework.TestCase;

public class TextCatTest extends TestCase {
	
	private static final String test = "Java programming language" +
	"From Wikipedia, the free encyclopedia." +
	"Jump to: navigation, search" +
	"" +
	"Java is an object-oriented programming language developed initially by James Gosling and colleagues at Sun Microsystems. Initially called Oak (named after the oak trees outside Gosling's office), it was intended to replace C++, although the feature set better resembles that of Objective-C. Sun Microsystems currently maintains and updates Java regularly." +
	"" +
	"Specifications of the Java language, the Java Virtual Machine (JVM) and the Java API are community-maintained through the Sun-managed Java Community Process. Java was developed in 1991 by Gosling and other Sun engineers, as part of the Green Project. After first being made public in 1994, it achieved prominence following the announcement at 1995's SunWorld that Netscape would be including support for it in their Navigator browser." +
	"" +
	"Java is often confused with JavaScript, with which it shares only a similar C-like syntax." +
	"Wikibooks" +
	"Wikibooks Programming has more about this subject:" +
	"Java" +
	"Contents" +
	"[hide]" +
	"" +
	"    * 1 History" +
	"          o 1.1 Early history" +
	"          o 1.2 Java meets the Internet" +
	"          o 1.3 Recent history" +
	"          o 1.4 Version history" +
	"    * 2 Language characteristics" +
	"          o 2.1 Object orientation" +
	"          o 2.2 Platform independence" +
	"          o 2.3 Automatic garbage collection" +
	"          o 2.4 Interfaces and classes" +
	"          o 2.5 Input/Output" +
	"          o 2.6 APIs" +
	"          o 2.7 Hello World example" +
	"          o 2.8 International and worldwide use" +
	"          o 2.9 Miscellaneous" +
	"    * 3 Criticism" +
	"          o 3.1 Language issues" +
	"          o 3.2 Library issues" +
	"          o 3.3 Performance issues" +
	"    * 4 Java Runtime Environment" +
	"    * 5 Extensions and related architectures" +
	"    * 6 See also" +
	"    * 7 References" +
	"    * 8 Notes" +
	"    * 9 External links" +
	"          o 9.1 Sun" +
	"          o 9.2 Alternatives" +
	"          o 9.3 Books" +
	"          o 9.4 General" +
	"          o 9.5 Historical" +
	"          o 9.6 Criticism" +
	"" +
	"[edit]" +
	"" +
	"History" +
	"Duke, Java's mascot" +
	"Duke, Java's mascot" +
	"[edit]" +
	"" +
	"Early history" +
	"" +
	"The Java platform and language began as an internal project at Sun Microsystems in December of 1990. Patrick Naughton, an engineer at Sun, had become increasingly frustrated with the state of Sun's C++ and C APIs (application programming interfaces) and tools. While considering moving to NeXT, Patrick was offered a chance to work on new technology and thus the Stealth Project was started." +
	"" +
	"The Stealth Project was soon renamed to the Green Project with James Gosling and Mike Sheridan joining Patrick Naughton. They, together with some other engineers, began work in a small office on Sand Hill Road in Menlo Park, California to develop a new technology, aimed at programming next generation smart appliances such as microwaves, which Sun expected to be a big application of future technology. The team originally considered C++ as the language to use, but many of them as well as Sun's chief scientist, Bill Joy, found C++ and the available APIs problematic for several reasons." +
	"" +
	"Their platform was an embedded platform and had limited resources. Many members found that C++ was too complicated and that developers often misused it. They found C++'s lack of garbage collection a problem, as well as its lack of portable facilities for security, distributed programming, and threading. Finally, they wanted a platform that could be easily ported to all types of devices." +
	"" +
	"According to the available accounts, Bill Joy had ideas of a new language combining the best of Mesa and C. In a paper called Further, he proposed to Sun that its engineers should produce an object-oriented environment based on C++. Initially, Gosling attempted to modify and extend C++, which he referred to as C++ ++ -- , but soon abandoned that in favor of creating an entirely new language, which he called Oak after the tree that stood just outside his office." +
	"" +
	"Like many stealth projects working on new technology, the team worked long hours and by the summer of 1992, they were able to demonstrate portions of the new platform including the Green OS, the Oak language, the libraries, and the hardware. Their first attempt focused on building a PDA-like device named Star7[1] having a highly graphical interface and a smart agent called \"Duke\" to assist the user. It was demonstrated on September 3, 1992." +
	"" +
	"In November of that year, the Green Project was spun off to become FirstPerson, Inc, a wholly owned subsidiary of Sun Microsystems, and the team relocated to Palo Alto. The FirstPerson team was interested in building highly interactive devices, and when Time Warner issued an RFP for a set-top box, FirstPerson changed their target and responded with a proposal for a set-top box platform. However, the cable industry felt that their platform gave too much control to the user and FirstPerson lost their bid to SGI. An additional deal with The 3DO Company for a set-top box also failed to materialize. Unable to generate any interest within the TV industry for their platform, the company was rolled back into Sun." +
	"[edit]" +
	"" +
	"Java meets the Internet" +
	"" +
	"In June and July of 1994, after a three-day brainstorming session with John Gage, James Gosling, Bill Joy, Patrick Naughton, Wayne Rosing, and Eric Schmidt, the team re-targeted its efforts yet again, this time to use the technology for the Web. They felt that with the advent of the Mosaic browser, the Internet was on its way to evolving into the same highly interactive vision that they had had for the cable TV network. As a prototype, Patrick Naughton wrote a small web browser, WebRunner, later renamed HotJava." +
	"" +
	"It was also in 1994 that Oak was renamed Java. A trademark search revealed that the name Oak had already been taken by a video adaptor card manufacturer, so the team searched for a new name. The name Java was coined at a local coffee shop frequented by some of the members. It is not clear whether the name is an acronym or not. Most likely it is not, although some accounts claim that it stands for the names of James Gosling, Arthur Van Hoff, and Andy Bechtolsheim, or Just Another Vague Acronym. Lending credence to the idea that Java owes its name to the products sold at the coffee shop is the fact that the first 4 bytes of any class file spells out the words CAFE BABE if read in hexadecimal (see Class (file format))." +
	"" +
	"In October of 1994, HotJava and the Java platform was demonstrated for Sun executives. Java 1.0a was made available for download in 1994, but the first public release of Java and the HotJava web browser came on May 23, 1995, at the SunWorld conference. The announcement was made by John Gage, the Director of Science for Sun Microsystems. His announcement was accompanied by a surprise announcement by Marc Andreessen, Executive Vice President of Netscape, that Netscape would be including Java support in its browsers. In January of 1996, the JavaSoft business group was formed by Sun Microsystems to develop the technology." +
	"[edit]" +
	"" +
	"Recent history" +
	"" +
	"After several years of popularity, Java's place in the browser has steadily eroded. For simple interactive animations, it has been almost completely superseded by Macromedia Flash and Shockwave. As of 2005 it tends only to be used for more complex applications like Yahoo! Games. It has also suffered from opposition by Microsoft which no longer plans to ship a Java platform with new versions of Internet Explorer or Windows." +
	"" +
	"By contrast, on the server-side of the Web, Java is far more popular than ever, with many websites using JavaServer Pages and other Java-based technologies in their front-ends." +
	"" +
	"On the desktop, stand-alone Java applications remain relatively unusual because of their large overhead. However, with the great advances in computer power in the last decade along with improvements in VM and compiler quality, several have gained widespread use, including the NetBeans and Eclipse IDEs, Limewire and the Azureus BitTorrent client. Also, Matlab's latest versions (at least from 6.0 and onwards) heavily depend on Java for rendering their user interface and part of their calculation functionalities." +
	"[edit]" +
	"" +
	"Version history" +
	"Java Web Start, introduced in Java 2, allows provisioning applications over the web by clicking a desktop icon or a link on a website." +
	"Enlarge" +
	"Java Web Start, introduced in Java 2, allows provisioning applications over the web by clicking a desktop icon or a link on a website." +
	"" +
	"The Java language has undergone several changes since JDK 1.0 as well as numerous additions of packages to the standard library:" +
	"" +
	"    * 1.0 (1996) — Initial release." +
	"    * 1.1 (1997) — Major additions, most notably the extensive retooling of the event model, as well as the introduction of inner classes." +
	"    * 1.2 (December 4, 1998) — Codename Playground. Major changes were made to the API (reflection was introduced, the Swing graphical API was integrated into the core classes etc) and to Sun's JVM (which was equipped with a JIT compiler). These had little impact on the language itself, however: the only change to the Java language was the addition of the keyword strictfp. This and subsequent releases were rebranded \"Java 2\", but this had no effect on any software version numbers." +
	"    * 1.3 (May 8, 2000) — Codename Kestrel. The most notable changes were: (Full list of changes)" +
	"          o HotSpot JVM introduced" +
	"          o RMI was changed to be based on CORBA" +
	"    * 1.4 (February 13, 2002) — Codename Merlin. As of 2004, the most widely used version. Changes included: (Full list of changes)" +
	"          o assert keyword." +
	"          o regular expressions modeled after Perl regular expressions" +
	"          o exception chaining allows an exception to encapsulate original lower-level exception" +
	"          o unblocking NIO (New IO)" +
	"          o logging API" +
	"          o image IO API for reading and writing images in formats like JPEG and PNG" +
	"          o integrated XML parser and XSLT processor" +
	"          o integrated security and cryptography extensions (JCE, JSSE, JAAS)" +
	"    * 5.0 (September 29, 2004) — Codename Tiger. (Originally numbered 1.5, which is still used as the internal version number.) Added a number of significant new language features. One in particular, annotations, has been argued to be modeled on Microsoft's C#, which was itself modeled on earlier versions of Java:" +
	"          o Generics — Provides compile-time type safety for collections and eliminates the need for most typecasts." +
	"          o Autoboxing/unboxing — Automatic conversions between primitive types (such as int) and wrapper types (such as Integer)." +
	"          o Metadata — also called annotations, allows language constructs such as classes and methods to be tagged with additional data, which can then be processed by metadata-aware utilities" +
	"          o Enumerations — the enum keyword creates a typesafe, ordered list of values (such as Day.MONDAY, Day.TUESDAY, etc.). Previously this could only be achieved by non-typesafe constant integers or manually constructed classes (typesafe enum pattern)." +
	"          o Enhanced for loop — the for loop syntax is extended with special syntax for iterating over each member of an array or Collection, using a construct of the form:" +
	"" +
	"for (Widget w: box) {" +
	"    System.out.println(w);" +
	"}" +
	"" +
	"This example iterates over box, assigning each of its items in turn to the variable w, which is then printed to standard output." +
	"" +
	"    * 6.0 (currently in development, estimated release date 2006) — Codename Mustang. An early development version of the Java SDK version 6.0 (internal version number 1.6) was made available in November 2004. New builds including enhancements and bug fixes are released on a regular basis." +
	"    * 7.0 — Codename Dolphin. As of 2005, this is in the early planning stages.[2]" +
	"" +
	"In addition to the language changes, much more dramatic changes have been made to the Java class library over the years, which has grown from a few hundred classes in version 1.0 to over three thousand in Java 5.0. Entire new APIs, such as Swing and Java2D, have been introduced, and many of the original 1.0 classes and methods have been deprecated." +
	"[edit]" +
	"" +
	"Language characteristics" +
	"" +
	"There were five primary goals in the creation of the Java language:" +
	"" +
	"    * It should use the object-oriented programming methodology." +
	"    * It should allow the same program to be executed on multiple computer platforms." +
	"    * It should contain built-in support for using computer networks." +
	"    * It should be designed to execute code from remote sources securely." +
	"    * It should be easy to use and borrow the good parts of older Object Oriented languages like C++." +
	"" +
	"Especially for the latter part, however, extensions are sometimes required, like CORBA or OSGi." +
	"[edit]" +
	"" +
	"Object orientation" +
	"" +
	"The first characteristic, object orientation (\"OO\"), refers to a method of programming and language design. Although there are many interpretations of OO, one primary distinguishing idea is to design software so that the various types of data it manipulates are combined together with their relevant operations. Thus, data and code are combined into entities called objects. An object can be thought of as a self-contained bundle of behavior (code) and state (data). The principle is to separate the things that change from the things that stay the same; often, a change to some data structure requires a corresponding change to the code that operates on that data, or vice versa. This separation into coherent objects provides a more stable foundation for a software system's design. The intent is to make large software projects easier to manage, thus improving quality and reducing the number of failed projects." +
	"" +
	"Another primary goal of OO programming is to develop more generic objects so that software can become more reusable between projects. It is easy to see why a generic \"customer\" object, for example, should in theory have roughly the same basic set of behaviors between different software projects, especially when these projects overlap on some fundamental level as they often do in large organizations. In this sense, software objects can hopefully be seen more as pluggable components, helping the software industry \"erect\" projects largely from existing and well tested pieces, thus leading to a massive reduction in development times. However, the reality of software reusability has met with mixed results, mostly due to two difficulties: the design of truly generic objects remains a poorly-understood art, and a methodology for broad communication of reuse opportunities eludes the science. Some open source communities are now emerging whose primary mission is to help ease the reuse problem by providing authors with ways to disseminate information about generally reusable objects and object libraries." +
	"[edit]" +
	"" +
	"Platform independence" +
	"The Look and Feel of a Java GUI is independent of the platform it is running on" +
	"Enlarge" +
	"The Look and Feel of a Java GUI is independent of the platform it is running on" +
	"" +
	"The second characteristic, platform independence, means that programs written in the Java language must run similarly on diverse hardware. One should be able to write a program once and run it anywhere." +
	"" +
	"This is achieved by most compilers by compiling the Java language code \"halfway\" to bytecode—simplified machine instructions specific to the Java platform. The code is then run on a virtual machine (VM), a program written in native code on the host hardware that interprets and executes generic Java bytecode. Further, standardized libraries are provided to allow access to features of the host machines (such as graphics, threading and networking) in unified ways. Note that, although there's an explicit compiling stage, at some point, the Java bytecode is interpreted or converted to native machine instructions by the JIT compiler." +
	"" +
	"There are also implementations of Java compilers that compile to native object code, such as GCJ, removing the intermediate bytecode stage, but the output of these compilers can only be run on a single architecture." +
	"" +
	"Sun's license for Java insists that all implementations be \"compatible\". This resulted in a legal dispute with Microsoft after Sun claimed that the Microsoft implementation did not support the RMI and JNI interfaces and had added platform-specific features of their own. Sun sued and won both damages (some $20 million) and a court order enforcing the terms of the license from Sun. In response, Microsoft no longer ships Java with Windows, and in recent versions of Windows, Internet Explorer cannot support Java applets without a third-party plugin. However, Sun and others have made available Java run-time systems at no cost for those and other versions of Windows." +
	"" +
	"The first implementations of the language used an interpreted virtual machine to achieve portability. These implementations produced programs that ran more slowly than programs written in C or C++, so the language suffered a reputation for poor performance. More recent JVM implementations produce programs that run significantly faster than before, using multiple techniques." +
	"" +
	"The first technique is to simply compile directly into native code like a more traditional compiler, skipping bytecodes entirely. This achieves good performance, but at the expense of portability. Another technique, known as just-in-time compilation (JIT), translates the Java bytecodes into native code at the time that the program is run. More sophisticated VMs use dynamic recompilation, in which the VM can analyze the behavior of the running program and selectively recompile and optimize critical parts of the program. These latter two techniques allow the program to take advantage of the speed of native code without losing portability." +
	"" +
	"Portability is a technically difficult goal to achieve, and Java's success at that goal has been mixed. Although it is indeed possible to write programs for the Java platform that behave consistently across many host platforms, the large number of available platforms with small errors or inconsistencies led some to parody Sun's \"Write once, run anywhere\" slogan as \"Write once, debug everywhere\"." +
	"" +
	"Platform-independent Java is, however, very successful with server-side applications, such as web services, servlets, or Enterprise Java Beans - and meanwhile also with Embedded systems based on OSGi, using Embedded Java environments." +
	"[edit]" +
	"" +
	"Automatic garbage collection" +
	"" +
	"One possible argument against languages such as C++ is the burden of having to perform manual memory management. In C++, memory is allocated by the programmer to create an object, then deallocated to delete the object. If a programmer forgets or is unsure when to deallocate, this can lead to a memory leak, where a program consumes more and more memory without cleaning up after itself. Even worse, if a region of memory is deallocated twice, the program can become unstable and will likely crash." +
	"" +
	"In Java, this potential problem is avoided by automatic garbage collection. Objects are created and placed at an address on the heap. The program or other objects can reference an object by holding a reference to its address on the heap. When no references to an object remain, the Java garbage collector automatically deletes the object, freeing memory and preventing a memory leak. Memory leaks, however, can still occur if a programmer's code holds a reference to an object that is no longer needed—in other words, they can still occur but at higher conceptual levels. But on the whole, Java's automatic garbage collection makes creation and deletion of objects in Java simpler and potentially safer than in C++." +
	"" +
	"It should be noted, however, that programmers have access to garbage collection in C++ via smart pointers, such as the ones provided by the Boost library or as specified in the C++ committee's technical report TR1 which will be incorporated into the next C++ ISO standard." +
	"" +
	"It should also be noted that garbage collection in Java is virtually invisible to the developer. That is, developers may have no notion of when garbage collection will take place as it is not necessarily a function of the code they themselves write." +
	"[edit]" +
	"" +
	"Interfaces and classes" +
	"" +
	"One thing that Java accommodates is creating an interface which classes can then implement. For example, an interface can be created like this:" +
	"" +
	"public interface Deleteable {" +
	"    void delete();" +
	"}" +
	"" +
	"This code says that any class that implements the interface Deleteable will have a method named delete(). The exact implementation and function of the method are determined by each class. There are many uses for this concept; for example, the following could be a class:" +
	"" +
	"public class Fred implements Deleteable {" +
	"     //Must include the delete () method to satisfy the Deleteable interface" +
	"     public void delete() { //code implementation goes here" +
	"     }" +
	"     //Can also include other methods" +
	"     public void doOtherStuff() {" +
	"     }" +
	"}" +
	"" +
	"Then, in another class, the following is legal code:" +
	"" +
	"public void deleteAll (Deleteable [] list) {" +
	"     for (int i = 0; i < list.length; i++) {" +
	"          list[i].delete();" +
	"     }" +
	"     //5.0 Tiger Implementation" +
	"     for( Deleletable d : list){" +
	"           d.delete();" +
	"     }" +
	"}" +
	"" +
	"because any objects in the array are guaranteed to have the delete() method. The Deleteable array may contain references to Fred objects, and the delete() method needn't differentiate between the Fred objects and other Deleteable objects." +
	"" +
	"The purpose is to separate the details of the implementation of the interface from the code that uses the interface. For example, the Collection interface contains methods that any collection of objects might want to implement, like retrieving or storing objects, but a specific collection could be a resizeable array, a linked list, or any of a number of different implementations." +
	"" +
	"The feature is a result of compromise. The designers of Java decided not to support multiple inheritance because of the difficulty of C++'s multiple inheritance, but interfaces give some of the benefit of multiple inheritance with, arguably, less complexity, but at the price of code redundancy (since interfaces only defines the signature of a class but cannot contain any implementation, every class inheriting an interface must provide the implementation of the defined methods, unlike in multiple inheritence, where the implementation is also inherited)." +
	"" +
	"Java interfaces behave much like the concept of the Objective-C protocol." +
	"[edit]" +
	"" +
	"Input/Output" +
	"" +
	"Versions of Java prior to 1.4 only supported stream-based blocking I/O. This required a thread per stream being handled, as no other processing could take place while the active thread blocked waiting for input or output. This was a major scalability and performance issue for anyone needing to implement any Java network service. Since the introduction of NIO (New IO) in Java 1.4, this scalability problem has been rectified by the introduction of a non-blocking I/O framework (though there are a number of open issues in the NIO API as implemented by Sun)." +
	"" +
	"The non-blocking IO framework, though considerably more complex than the original blocking IO framework, allows any number of \"channels\" to be handled by a single thread. The framework is based on the Reactor Pattern." +
	"[edit]" +
	"" +
	"APIs" +
	"" +
	"Sun has defined three platforms targeting different application environments and segmented many of its APIs so that they belong to one of the platforms. The platforms are:" +
	"" +
	"    * Java 2 Platform, Micro Edition — targeting environments with limited resources," +
	"    * Java 2 Platform, Standard Edition — targeting workstation environments, and" +
	"    * Java 2 Platform, Enterprise Edition — targeting large distributed enterprise or Internet environments." +
	"" +
	"The classes in the Java APIs are organized into separate groups called packages. Each package contains a set of related interfaces, classes and exceptions. Refer to the separate platforms for a description of the packages available." +
	"" +
	"The set of APIs is controlled by Sun Microsystems in cooperation with others through its Java Community Process program. Companies or individuals participating in this process can influence the design and development of the APIs. This process has been a subject of controversy." +
	"" +
	"In 2004, IBM and BEA publicly supported the notion of creating an official open source implementation of Java but as of 2005, Sun Microsystems has refused that." +
	"[edit]" +
	"" +
	"Hello World example" +
	"" +
	"For an explanation of the tradition of programming \"Hello World\", see Hello world program." +
	"" +
	"// The source file must be named WorldGreeting.java" +
	"public class WorldGreeting {" +
	"    // The main method is passed an array of command-line parameters" +
	"    public static void main(String[] args) {" +
	"        System.out.println(\"Hello world!\");" +
	"    }" +
	"}" +
	"" +
	"The above example merits a bit of explanation for those accustomed to languages with inherently relaxed security, weak typing, and weak object orientation." +
	"" +
	"    * Everything in Java is written inside a class, including stand-alone programs." +
	"    * Source files are by convention named the same as the class they contain, appending the mandatory suffix .java. Classes which are declared public are required to follow this convention. (In this case, the class is WorldGreeting, therefore the source must be stored in a file called WorldGreeting.java)." +
	"    * The compiler will generate a class file for each class defined in the source file. The name of the class file is the name of the class, with .class appended. For class file generation, anonymous classes are are treated as if their name was the concatenation of the name of their enclosing class, a $, and an integer." +
	"    * Programs to be executed as stand-alone must have a main() method." +
	"    * The keyword void indicates that the main() method does not return anything." +
	"    * The main method must accept an array of strings. By convention, it is referenced as \"args\" although any other legal variable name can be used." +
	"    * The keyword static indicates that the method is a class method, associated with the class rather than object instances. Main methods must be static." +
	"    * The keyword public denotes that a method can be called from code in other classes, or that a class may be used by classes outside the class hierarchy." +
	"    * The printing facility is part of the java standard library: The System class defines a public field called \"out\". The \"out\" object provides the method println() for displaying data to the screen (standard out)." +
	"    * Standalone programs are run by giving the Java runtime the name of the class whose main() method is to be invoked. For example, at a Unix command line java -cp . WorldGreeting will start the above program (compiled into WorldGreeting.class) from the current directory. The name of the class whose main method is to be invoked can also be specified in the MANIFEST of a Java archive (jar) file." +
	"" +
	"[edit]" +
	"" +
	"International and worldwide use" +
	"" +
	"The language distinguishes between bytes and characters. Characters are stored internally using UCS-2, although as of Java 5, the language also supports using UTF-16 via surrogates. Java program source may therefore contain any Unicode character." +
	"" +
	"The following is thus perfectly valid java code; it contains Chinese characters in the class and variable names as well as in a string literal:" +
	"" +
	"public class ???? {" +
	"    private String ?? = \"\";" +
	"}" +
	"" +
	"[edit]" +
	"" +
	"Miscellaneous" +
	"" +
	"Although the language has special syntax for them, arrays and strings are not primitive types: they are reference types that can be assigned to java.lang.Object." +
	"[edit]" +
	"" +
	"Criticism" +
	"" +
	"Java was intended to serve as a novel way to manage software complexity. Most consider Java technology to deliver reasonably well on this promise. However, Java is not without flaws, and it does not universally accommodate all programming styles, environments, or requirements." +
	"" +
	"    * Not all projects or environments require enterprise-level complexity, such as stand-alone websites or sole-proprietorship programmers. Such individuals find Java's self-enforcing complexity management to be overkill." +
	"    * Java is often a focal point of discontent for those who are not enthusiastic about object-oriented programming." +
	"    * Java can be considered a less pure object-oriented programming language than for instance Ruby or Smalltalk because it makes certain compromises (such as the fact that not all values are objects) for performance reasons." +
	"    * As an established technology, Java inevitably invites comparison with contemporary languages such as C++, C#, Python, and others. Commenting upon Java's proprietary nature, supposed inflexibility to change, and growing entrenchment in the corporate sector, some have said that Java is \"the new COBOL\". Many consider this to be a somewhat hyperbolic assertion, although it does allude to some legitimate concerns with Java's prospects for the future." +
	"" +
	"[edit]" +
	"" +
	"Language issues" +
	"" +
	"    * The division between primitive types and objects is disliked by programmers familiar with languages such as Smalltalk and Ruby where everything is an object." +
	"" +
	"    * Conversely, C++ programmers can become confused with Java because in Java primitives are always automatic variables and objects always reside on the heap, whereas C++ programmers are explicitly given the choice in both cases by means of pointers." +
	"" +
	"    * Java code is often more verbose than code written in other languages due to its frequent type declarations." +
	"" +
	"    * Java is predominantly a single-paradigm language. Historically, it has not been very accommodating of paradigms other than object-oriented programming. As of version 5.0, the procedural paradigm is somewhat better supported in Java with the addition of the ability to import static methods and fields so that they can be used globally as one could do in, for example, C." +
	"" +
	"    * Java is a single inheritance language. This causes consternation to programmers accustomed to multiple inheritance, which is available in many other languages. However, Java employs interface classes, which are argued to address certain issues with multiple inheritance while retaining some of its benefits." +
	"" +
	"    * Java does not support user-definable operator overloading, unlike C++." +
	"" +
	"    * Versions of Java before 5.0 required many explicit casts to be written due to the lack of generic types." +
	"" +
	"    * Java's support of text matching and manipulation is not as strong as languages such as perl or PHP, although regular expressions were introduced in J2SE 1.4." +
	"" +
	"[edit]" +
	"" +
	"Library issues" +
	"" +
	"The look and feel of GUI applications written in Java using the Swing platform is often different from native applications. While programmers can choose to use the AWT toolkit that displays native widgets (and thus look like the operating platform), the AWT toolkit is unable to meet advanced GUI programming needs by wrapping around advanced widgets and not sacrificing portability across the various supported platforms, each of which have vastly different APIs especially for higher-level widgets. The Swing toolkit, written completely in Java, avoids this problem by reimplementing widgets using only the most basic drawing mechanisms that are guaranteed available on all platforms. The drawback is that extra effort is required to resemble the operating platform. While this is possible (using the GTK+ and Windows Look-and-Feel), most users do not know how to change the default Metal Look-And-Feel to one that resembles their native platform, and as a result they are stuck with Java applications that look radically different from their native applications. Of note however, Apple Computer's own optimized version of the Java Runtime, which is included within the Mac OS X distribution, by default implements its \"Aqua\" Look-And-Feel, giving Swing applications instant familiarity to Mac users." +
	"" +
	"Some parts of the standard Java libraries are considered excessively complicated, or badly designed, but cannot be changed due to the need for backward compatibility." +
	"[edit]" +
	"" +
	"Performance issues" +
	"" +
	"Java has obtained a reputation for slow performance, primarily because most users have targeted the Java virtual machine rather than compiling the language directly to native machine code. Using a JVM imposes a fairly large speed penalty, either spread throughout the whole program (if using an interpreter JVM) or imposed once at class loading time (if using a JIT-compiling JVM). In the latter case, the penalty is particularly noticable in programs which run for only a short time." +
	"" +
	"Whether or not modern implementations of Java are significantly slower than other languages is still hotly debated. Many argue that this is a misconception based on old benchmarks and information produced by competitors. Nevertheless, use of Java for major desktop applications still remains rare, and for highly CPU-intensive applications the language is not used at all." +
	"" +
	"A number of language features unavoidably harm performance and memory usage, even if native compilation is used:" +
	"" +
	"    * Garbage collection" +
	"    * Array bounds checking" +
	"    * Run-time type checking" +
	"" +
	"Java was designed with an emphasis on security and portability, so low-level features like hardware-specific data types and pointers to arbitrary memory were deliberately omitted. In low-level applications which require these features, they must be accessed by calling C code using the Java Native Interface (JNI), which can itself be a performance bottleneck." +
	"[edit]" +
	"" +
	"Java Runtime Environment" +
	"" +
	"The Java Runtime Environment or JRE is the software required to run any application deployed on the Java platform. End-users commonly use a JRE in software packages and plugins. Sun also distributes a superset of the JRE called the Java 2 SDK (more commonly known as the JDK), which includes development tools such as the Java compiler, Javadoc, and debugger." +
	"" +
	"Components of the JRE" +
	"" +
	"    * Java libraries - which are the compiled byte codes of source developed by the JRE implementor to support application development in Java. Examples of these libraries are:" +
	"          o The core libraries, which include:" +
	"                + Collection libraries which implement data structures such as lists, dictionaries, trees and sets" +
	"                + XML Parsing libraries" +
	"                + Security" +
	"                + Internationalization and Localization libraries" +
	"          o The integration libraries, which allow the application writer to communicate with external systems. These libraries include:" +
	"                + The Java Database Connectivity (JDBC) API for database access" +
	"                + Java Naming and Directory Interface (JNDI) for lookup and discovery" +
	"                + RMI and CORBA for distributed application development" +
	"          o User Interface libraries, which include:" +
	"                + The (heavyweight, or native) Abstract Windowing Toolkit (AWT), which provides GUI components, the means for laying out those components and the means for handling events from those components" +
	"                + The (lightweight) Swing libraries, which are built on AWT but provide (non-native) implementations of the AWT widgetry" +
	"                + APIs for audio capture, processing, and playback" +
	"    * A platform dependent implementation of Java virtual machine (JVM) which is the means by which the byte codes of the Java libraries and third party applications are executed" +
	"    * Plugins, which enable applets to be run in web browsers" +
	"    * Java Web Start, which allows Java applications to be efficiently distributed to end users across the Internet" +
	"    * Licensing and documentation" +
	"" +
	"[edit]" +
	"" +
	"Extensions and related architectures" +
	"" +
	"Extensions and architectures closely tied to the Java programming language include:" +
	"" +
	"    * J2EE (Enterprise edition)" +
	"    * J2ME (Micro-Edition for PDAs and cellular phones)" +
	"    * JMF (Java Media Framework)" +
	"    * JNDI (Java Naming and Directory Interface)" +
	"    * JSML (Java Speech API Markup Language)" +
	"    * JDBC (Java Database Connectivity)" +
	"    * JDO (Java Data Objects)" +
	"    * JAI (Java Advanced Imaging)" +
	"    * JAIN (Java API for Integrated Networks)" +
	"    * JDMK (Java Dynamic Management Kit)" +
	"    * Jini (a network architecture for the construction of distributed systems)" +
	"    * Jiro" +
	"    * Java Card" +
	"    * JavaSpaces" +
	"    * Java Modeling Language (JML)" +
	"    * JMI (Java Metadata Interface)" +
	"    * JMX (Java Management Extensions)" +
	"    * JSP (JavaServer Pages)" +
	"    * JSF (JavaServer Faces)" +
	"    * JNI (Java Native Interface)" +
	"    * JXTA (Open Protocols for P2P Virtual Network)" +
	"    * J3D (A high level API for 3D graphics programming)" +
	"    * JOGL (A low level API for 3D graphics programming, using OpenGL)" +
	"    * OSGi (Dynamic Service Management and Remote Maintenance)" +
	"    * SuperWaba (JavaVMs for handhelds)" +
	"" +
	"[edit]" +
	"" +
	"See also" +
	"" +
	"    * Java virtual machine" +
	"    * Java applet" +
	"    * Comparison of Java to C++" +
	"    * Optimization of Java" +
	"    * Java Platform Debugger Architecture" +
	"    * Join Java programming language" +
	"    * List of Java-programs" +
	"    * Java User Group" +
	"    * Java XML" +
	"    * Java Servlet" +
	"    * Java 2 Platform, Standard Edition (J2SE)" +
	"    * List of Java scripting languages" +
	"    * Javapedia" +
	"    * Java Community Process" +
	"    * JavaOS" +
	"    * Java keywords" +
	"    * zAAP (Java processor)" +
	"    * Microsoft J++" +
	"" +
	"[edit]" +
	"" +
	"References" +
	"" +
	"    * Jon Byous, Java technology: The early years. Sun Developer Network, no date [ca. 1998]. Retrieved April 22, 2005." +
	"    * James Gosling, A brief history of the Green project. Java.net, no date [ca. Q1/1998]. Retrieved April 22, 2005." +
	"    * James Gosling, Bill Joy, Guy Steele, and Gilad Bracha, The Java language specification, second edition. Addison-Wesley, 2000. ISBN 0201310082." +
	"    * James Gosling, Bill Joy, Guy Steele, and Gilad Bracha, The Java language specification, third edition. Addison-Wesley, 2005. ISBN 0321246780." +
	"    * Tim Lindholm and Frank Yellin. The Java Virtual Machine specification, second edition. Addison-Wesley, 1999. ISBN 0201432943." +
	"" +
	"[edit]" +
	"" +
	"Notes" +
	"" +
	"   1. ^ The device was named Star7 after a telephone feature activated by *7 on a telephone keypad, which enabled users to answer the telephone anywhere." +
	"" +
	"[edit]" +
	"" +
	"External links" +
	"This article or section has or is prone to spam, that is, HTML links added only to promote a site or product." +
	"Following Wikipedia:External links, please help Wikipedia by removing any commercial links on sight. Please retain this notice if necessary, and report rampant spamming as per instructions at Wikipedia:Spam. (you can help!)" +
	"[edit]" +
	"" +
	"Sun" +
	"" +
	"    * Official Java home site" +
	"    * The Java Language Specification, Third edition Authoritative description of the Java language" +
	"    * J2SE API reference, v5.0" +
	"    * Sun's tutorial on Java Programming" +
	"    * Original Java whitepaper, 1996" +
	"    * Test your Java VM" +
	"" +
	"[edit]" +
	"" +
	"Alternatives" +
	"" +
	"    * Blackdown Java for Linux, includes Mozilla plugin" +
	"    * GNU Classpath from GNU" +
	"" +
	"[edit]" +
	"" +
	"Books" +
	"" +
	"    * Computer-Books.us A collection of Java books available for free download" +
	"    * David Flanagan, [Java in a Nutshell, Third Edition]. O'Reilly & Associates, 1999. ISBN 1565924878" +
	"    * Thinking in Java, by Bruce Eckel" +
	"    * Java Course The well-known book of A.B. Downey as an HTMLHelp based eBook" +
	"" +
	"[edit]" +
	"" +
	"General" +
	"" +
	"    * Newsgroup comp.lang.java (Google Groups link), and its FAQ" +
	"    * Javapedia project" +
	"    * The Java Wiki" +
	"    * A Java glossary" +
	"    * Java Basics Manual" +
	"    * Java-API with examples" +
	"    * Java: Cornerstone of the Global Network Enterprise" +
	"    * Sun Certification Resource" +
	"" +
	"[edit]" +
	"" +
	"Historical" +
	"" +
	"    * Java(TM) Technology: The Early Years" +
	"    * A Brief History of the Green Project" +
	"    * Java Was Strongly Influenced by Objective-C" +
	"    * The Java Saga" +
	"    * A history of Java" +
	"" +
	"[edit]" +
	"" +
	"Criticism" +
	"" +
	"    * Paul Graham, Java's Cover. Paulgraham.com, April 2001." +
	"    * Simson Garfinkel, Java: Slow, ugly and irrelevant. Salon.com, January 8, 2001." +
	"    * Free But Shackled — The Java Trap, by Richard Stallman, April 12, 2004. (James Gosling's response)" +
	"    * The Dark Side of Java (PDF), by Conrad Weisert, August 29, 1997. (View as HTML)" +
	"    * java sucks, by Jamie Zawinski, 2000." +
	"    * Why I Am Not A Java Programmer, by Michael G. Schwern.";
	
	public void testTextCat() {
		String str = TextCatTest.test + TextCatTest.test;
		str += str;
		
		long time = System.currentTimeMillis();
		TextCategorizer tc = new TextCategorizer();
		assertEquals("english", tc.categorize(str));
		System.out.println("Time:" + (System.currentTimeMillis() - time));
	}
	
	
}
