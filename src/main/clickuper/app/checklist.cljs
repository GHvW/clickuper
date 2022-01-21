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


(defn action-handler
  [task-id file]
  (.log js/console (str "file: " file ", " "task-id: " task-id)))


(comment
  
  (action-handler "DEV-0001" "thelist.txt")

  (make-checklist "dev test" ["first one", "second one", "thrid one"])
  )