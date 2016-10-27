Grant, Guhan, Austin -- gac19, gm114, aeg36



Changes
===

Model to Model: Originally we thought model to model was going to be doing a lot with the turtle. But in reality it's really creating the expression tree and also have the implementation of how it will execute. It consists of the parsing the expression tree builder, something to translate the text input, something to hold the commands in a list, and something to translate the string commands to nodes in the tree. Within this there is a class for every single command. This is represented in a hierarchy. The execution is defined in each of these sub classes.  These changes were pretty major since we misunderstood initially what to do. We hope that these changes are for the better. This means that hopefully we think there will be only minor changes to come in the future. 

Model to View: The controller which calls the execution of the tree. Gets the tree from the backend, executes everything and calls the visualization. Gives the visualization as a packet of info that the scene calls and parses through to get info it needs. It is different from our original API because we thought there wasn't going to be a lot of methods. It is encompassing of what we thought, but then just addition methods to help. I would say this is not that big of a deal, just some minor changes and addition as we realized we'd need more methods. We think any changes are for the better, however we do need to change some of the hierarchy which will be a pretty big deal over the next few days. 

View to Model: These are all the methods that exist in updater. Basically the it has methods that the controller has access to and can call to update the location of the turtle with the given information that it has. This is different from what we originally thought but not by much. Again it is similar to the model to View except more commands have been added to support things we didn't think about initially. This will also be a part of the major changes that we need to make when redesigning. We think our design on this was for the better. 

View to View: This is all the commands that communicate between the generator, the updater and the scene. We feel that a major change has been made from our original thought because it is not split up into components. Over the next few days we plan to split this up into components such that it is better designed and also allows more flexibility to add more components. These changes will be significant. 