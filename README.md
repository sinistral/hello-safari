# Hello, Safari

This is an example of how to set up a minimal, REPL-connected Safari extension
in [ClojureScript][cljs] and [Boot][boot].  Assuming a [CIDER][cider]-based
development environment, the path to the REPL is:

* In a terminal: `boot build -- cider -- dev` to:
    * build and package the extension, so that it can be installed in Safari,
    * load a `cider` [Boot profile][profile], and
    * start the nREPL server, and rebuild the extension when changes are made.
* In Emacs: `M-x cider-connect` to connect to the nREPL server and,
  once-connected (i.e. when the `boot.user>` prompt appears):
  `(start-repl)`.
* The REPL will now wait for a client (browser) to connect to the
  websocket.
* In Safari: add/reload the extension using Safari's
  [_Extension Builder_][extb] (select the `hellosafari.safariextension`
  directory in the project's `tgt` directory).  When it starts up, the
  extension will connect to the websocket and run the `init-fn`
  (cf. `main.cljs.edn`).
* Open the _Web Inspector_ for the extension (by clicking the `Inspect Global
Page` button) to see the message that is logged by the main function.

## Caveats

The Safari extension sandbox and `boot-cljs-reload` don't play well together.
To reload the extension, use the [_Extension Builder_][extb]'s `Reload` button.
While less convenient than `boot-cljs-reload`'s auto-reload, being able to
evaluate forms in the REPL does still make it possible to iterate quickly.

## License

Copyright © 2016 Marc Daya

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[boot]:    https://github.com/boot-clj/boot
[cljs]:    https://github.com/clojure/clojurescript
[cider]:   https://github.com/clojure-emacs/cider
[profile]: https://github.com/boot-clj/boot/wiki/Cider-REPL#a-better-way
[extb]:    https://developer.apple.com/library/content/documentation/Tools/Conceptual/SafariExtensionGuide/UsingExtensionBuilder/UsingExtensionBuilder.html
