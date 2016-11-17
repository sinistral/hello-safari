
(ns hellosafari.core
  (:require [hellosafari.env :as env]))

(defn main
  []
  (let [msg "hello, world; you have %d safari windows."]
    (.info js/console msg (-> js/safari .-application .-browserWindows .-length))))
