(ns clickuper.app.checklist)

(defn make-checklist
  [name items]
  {:name name
   :items (map-indexed (fn [index item]
                         {:name item
                          :orderindex index})
                       items)})


(defn read-checklist
  [path]
  ())


(comment
  (make-checklist "dev test" ["first one", "second one", "thrid one"]))