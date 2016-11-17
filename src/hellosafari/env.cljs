
(ns hellosafari.env)

(defn app
  []
  (-> js/safari (.-application)))

(defn ext
  []
  (-> js/safari (.-extension)))
