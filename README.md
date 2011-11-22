SBT Plugin to generate shell scripts to run project code.

Before I wrote this, in order to test project code I would have to ```publish-local```, then run a [https://github.com/harrah/xsbt/wiki/Scripts](scalas) script.  This was very time consuming.

Now I just run ```sbt ~compile``` in one window, and in other windows have the bash scripts running.  After a new compile in the bash window I would just ^C, up arrow, return in order to restart the scripts.  This is much faster.

This is not published as of now, I just do a ```publish-local``` to use in another project.
