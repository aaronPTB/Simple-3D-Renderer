# Simple-3D-Renderer
A project I worked on back in highschool. I still think it's pretty cool, so I'm opening up the source on github.

It's also worth noting that I made this during the dying breaths of the Java web applet, so it's old interface is broken.

##If anyone wants to fork this and fix it:
 
observer is the camera and will render the points as they appear in the 3d environment. This means it will give you (x,y)     coordinates of where the objects appear to be **on the screen**.

All of the complex math has already been abstracted away for you, so it shouldn't be too hard of a fix if you can find another environment to draw in. You can find these 2d points by calling camera.lookAt(RenderObject obj). In hindsight this is a little vague. lookAt does not redirect the camera, it simply allows for the object's verticies to be rendered.

The import code for rendering is all located in Workspace.java

Feel free to take a crack at it if you stumble upon this, and send me a message if you fix it
