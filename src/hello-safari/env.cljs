
(ns hello-safari.env)

(defn app
  []
  (-> js/safari (.-application)))

(defn ext
  []
  (-> js/safari (.-extension)))
