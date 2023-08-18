# SWEN501_Diagram

The diagram editor I made is a fully responsive design tool that can 
be controlled mainly by mouse. In this project, I can control and edit any shape
and images on the canvas while adding new graphics or deleting them.

The following functionalities can be implemented:
1. The user can press and drag any shape(s) under the mouse.
    (e.g if the mouse area covers two shapes, they would be dragged together)
2. From pressed to released, shapes don't jump around. The shapes move exactly
    as much as the mouse moves in this process.
3. By clicking the shape itself (not press and drag), the shape will be selected
    and the UI will turn on a modal-mode with prompts. In this mode, there are 
    three actions that can be implemented. 
     (1) Firstly, clicking the item itself will make it removed on the canvas and deleted 
          in the Arraylist that actually holds it.
     (2) Secondly, clicking anywhere but the selected item itself will turn off the modal-mode.
     (3) Thirdly, pressing key 'w', 's', 'a', 'd' will change the size of the selected shape.
      * The selected shape will be tagged with red border.
      * In this mode, no other actions, such as dragging, could be implemented.
4. Images can do the same as shapes in this editor. All diagram elements could 
    be edited separately and individually.

In order to ensure good processing and rendering, I divided the whole project into four 
packages containing different classes: Core, EventListener, Module and UI. 
In the Module package, there is a superclass 'Diagram' which is inherited from shape and image classes. 
In the UI package, I divide input and output parts to ensure that I can control 
any parts individually. Especially in the output of UI, I separate all kinds of methods. 
In this way, I can control almost all the rendering issues. One of the key methods I use is that I can
make sure there is no dragging trace when dragging an item inside another item; another one 
is that there is no overlapping errors when all sorts of events are invoked.

For better testing and demonstration, I created a 'Add ramdon ' button which can create a 
shape with ramdon position, size and color. Or can just add a shape that we can specify its 
argument manually. There is a 3-sec opening animation when the UI is initialised. After that,
press whatever button on the left-hand side.

