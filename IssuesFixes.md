# What Can Go Wrong?


* Issue: Circular Dependency Error During Deployment

    ![CircularDependencyErrorExample](images/circularDependencyError.png)

    * Fix: File >> Project Structure >> Artifacts. Use the "-" to delete the two wars that start with User.  

    ![CircularDependencyErrorExample](images/Before-Artifacts.png)