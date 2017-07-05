# CLJ-HTML-COMPRESSOR

[![Clojars Project](https://img.shields.io/clojars/v/clj-html-compressor.svg)](https://clojars.org/clj-html-compressor)

Clojure interlop library for [htmlcompressor](https://code.google.com/archive/p/htmlcompressor/)

## Usage

```clojure
(ns you-project-ns
  (:require [clj-html-compressor.core :as compressor]))

; with one argument and default settings
(compressor/compress html)

; or two arguments, first html string, second compiler configuration
(compressor/compress html {})
```

## Config options (with default values)

```clojure
{:compress-css false ; Enables CSS compression within <style> tags using Yahoo YUI Compressor if set to true.
 :css-compressor nil ; Sets CSS compressor implementation that will be used to compress inline CSS in HTML.
 :compress-javascript false ; Enables JavaScript compression within <script> tags using Yahoo YUI Compressor if set to true.
 :javascript-compressor nil ; Sets JavaScript compressor implementation that will be used to compress inline JavaScript in HTML.
 :enabled true ; If set to false all compression will be bypassed.
 :generate-statistics false ; If set to true, HTML compression statistics will be generated.
 :preserve-line-breaks false ; If set to true, line breaks will be preserved.
 :preserve-patterns nil ; This method allows setting custom block preservation rules defined by regular expression patterns.
 :remove-comments true ; If set to true all HTML comments will be removed.
 :remove-form-attributes false ; If set to true, method="get" attributes will be removed from <form> tags. Default is false.
 :remove-http-protocol false ; If set to true, HTTP protocol will be removed from href, src, cite, and action tag attributes.
 :remove-https-protocol false ; If set to true, HTTPS protocol will be removed from href, src, cite, and action tag attributes.
 :remove-input-attributes false ; If set to true, type="text" attributes will be removed from <input> tags.
 :remove-intertag-spaces false ; If set to true all inter-tag whitespace characters will be removed.
 :remove-javascript-protocol false ; If set to true, javascript: pseudo-protocol will be removed from inline event handlers.
 :remove-link-attributes false ; If set to true, following attributes will be removed from <link rel="stylesheet"> and <link rel="alternate stylesheet"> tags: type="text/css" type="text/plain"
 :remove-multi-spaces true ; If set to true all multiple whitespace characters will be replaced with single spaces.
 :remove-quotes false ; If set to true all unnecessary quotes will be removed from tag attributes.
 :remove-script-attributes false ; If set to true, following attributes will be removed from <script> tags: type="text/javascript" type="application/javascript" language="javascript"
 :remove-style-attributes false ; If set to true, type="text/style" attributes will be removed from <style> tags.
 :remove-surrounding-spaces nil ; Enables surrounding spaces removal around provided comma separated list of tags.
 :simple-boolean-attributes false ; If set to true, any values of following boolean attributes will be removed: checked selected disabled readonly
 :simple-doctype false ; If set to true, existing DOCTYPE declaration will be replaced with simple <!DOCTYPE html> declaration.
 :yui-css-line-break -1 ; Tells Yahoo YUI Compressor to break lines after the specified number of symbols during CSS compression.
 :yui-error-reporter nil ; Sets ErrorReporter that YUI Compressor will use for reporting errors during JavaScript compression.
 :yui-js-disable-optimizations false ; Tells Yahoo YUI Compressor to disable all the built-in micro optimizations during JavaScript compression.
 :yui-js-line-break -1 ; Tells Yahoo YUI Compressor to break lines after the specified number of symbols during JavaScript compression.
 :yui-js-no-munge false ; Tells Yahoo YUI Compressor to only minify javascript without obfuscating local symbols.
 :yui-js-preserve-all-semicolons false} ; Tells Yahoo YUI Compressor to preserve unnecessary semicolons during JavaScript compression.
```

## Testing

Run command: `lein test`

## Contributing

1. Fork it!
2. Create branch `git checkout -b my-fix-branch master
3. Commit your changes: `git commit -am '<type>(<scope>): <subject>'. See Commit Message Format below.
4. Push to the branch: `git push origin my-fix-branch`
5. Submit a pull request!

```bash
git clone https://github.com/Atsman/clj-html-compressor.git
cd clj-html-compressor
lein install
```
## <a name="commit"></a> Git Commit Guidelines

We have very precise rules over how our git commit messages can be formatted.  This leads to **more
readable messages** that are easy to follow when looking through the **project history**.

### Commit Message Format
Each commit message consists of a **header**, a **body** and a **footer**.  The header has a special
format that includes a **type**, a **scope** and a **subject**:

```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

The **header** is mandatory and the **scope** of the header is optional.

Any line of the commit message cannot be longer 100 characters! This allows the message to be easier
to read on GitHub as well as in various git tools.

### Revert
If the commit reverts a previous commit, it should begin with `revert: `, followed by the header of the reverted commit.
In the body it should say: `This reverts commit <hash>.`, where the hash is the SHA of the commit being reverted.

### Type
Must be one of the following:

* **feat**: A new feature
* **fix**: A bug fix
* **docs**: Documentation only changes
* **style**: Changes that do not affect the meaning of the code (white-space, formatting, missing
  semi-colons, etc)
* **refactor**: A code change that neither fixes a bug nor adds a feature
* **perf**: A code change that improves performance
* **test**: Adding missing or correcting existing tests
* **chore**: Changes to the build process or auxiliary tools and libraries such as documentation
  generation

### Scope
The scope could be anything specifying place of the commit change. For example `$location`,
`$browser`, `$compile`, `$rootScope`, `ngHref`, `ngClick`, `ngView`, etc...

You can use `*` when the change affects more than a single scope.

### Subject
The subject contains succinct description of the change:

* use the imperative, present tense: "change" not "changed" nor "changes"
* don't capitalize first letter
* no dot (.) at the end

### Body
Just as in the **subject**, use the imperative, present tense: "change" not "changed" nor "changes".
The body should include the motivation for the change and contrast this with previous behavior.

### Footer
The footer should contain any information about **Breaking Changes** and is also the place to
[reference GitHub issues that this commit closes][closing-issues].
