(ns leiningen.new.datasplash
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "datasplash"))

(defn datasplash
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' datasplash project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
