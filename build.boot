
(set-env!
 :dependencies '[;; Project dependencies
                 [org.clojure/clojure         "1.8.0"]
                 [org.clojure/clojurescript   "1.9.293"]
                 ;; Build and REPL dependencies
                 [adzerk/boot-cljs            "1.7.228-2"      :scope "test"]
                 [adzerk/boot-cljs-repl       "0.3.3"          :scope "test"]
                 [com.cemerick/piggieback     "0.2.1"          :scope "test"]
                 [weasel                      "0.7.0"          :scope "test"]
                 [org.clojure/tools.nrepl     "0.2.12"         :scope "test"]])

(require
  '[clojure.java.io       :as io]
  '[adzerk.boot-cljs      :refer [cljs]]
  '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])

(def proj-name "hello-safari")
(def extn-name "hello-safari.safariextension")

(set-env!
 :source-paths #{"src"}
 :resource-paths #{(.getPath (io/file "ext" extn-name))
                   (.getPath (io/file "res" "static"))})

(deftask extn
  []
  (target :dir #{(.getPath (io/file "tgt" extn-name))}))

(deftask dev
  []
  (comp (watch)
        (speak)
        (cljs-repl)
        (cljs :source-map true :optimizations :none)
        (extn)))

(deftask build
  []
  (comp (cljs :optimizations :simple)
        (extn)))
