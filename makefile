run:Main.class
	@java Xor $(ARGS)

Main.class: Xor.java
	@javac Xor.java

clean: 
	rm Xor.class