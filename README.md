# Interview Question

Update the source file in the `challenge1/src` folder to make the JUnit 4 tests in the `challenge1/test` folder pass.

## Submitting Your Changes

Once you have the tests passing, use [git triangular workflow](https://www.sociomantic.com/blog/2014/05/git-triangular-workflow/)
to submit your implementation. This means you push contributions directly into the [main 
repo](https://github.com/dhumeniuk/interview-question). All changes come in through pull requests. So you 
will need to [fork the main repo](https://github.com/dhumeniuk/interview-question/fork) on GitHub. All
contributions are made as commits to your fork. Then you submit a pull request to have the change visible.

### Setting up the triangular workflow

After forking the main repo on GitHub, you can clone the main repo to your system:

    git clone https://github.com/dhumeniuk/interview-question.git

This will clone the main repo to a local repo on your disk and set up the `origin` remote in Git.
Next you will set up the the second side of the triangle to your fork repo.

    cd interview-question
    git remote add fork git@github.com:github-user/interview-question.git

Make sure to replace the URL with the SSH URL to your fork repo on GitHub. Then we configure
the local repo to push your commits to the fork repo.

    git config remote.pushdefault fork

So now you will pull from `origin`, the main repo, and push to `fork`, your fork repo.
This option requires at least Git 1.8.4. It is also recommended that you configure

    git config push.default simple

unless you are already using Git 2.0 where it is the default.

Finally, the third side of the triangle is pull requests from your fork repo to the
main repo.
