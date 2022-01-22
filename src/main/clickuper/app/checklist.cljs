(ns clickuper.app.checklist
  (:require
   ["fs/promises" :refer [readFile]]
   [clojure.string :as str]
   ["chalk" :as chalk]
   [clickuper.app.renderers :refer [render-checklist-success render-error]]))


(defn make-checklist
  [name items]
  {:name name
   :items (map-indexed (fn [index item]
                         {:name item
                          :orderindex index})
                       items)})


(defn text->items
  [text-blob]
  (str/split text-blob "\n"))


(defn action-handler
  [create-checklist task-id file-path]
  (.log js/console (str "file: " file-path ", " "task-id: " task-id))
  (-> (readFile file-path)
      (.then (comp (partial create-checklist task-id)
                   (partial make-checklist "Dev Test")
                   text->items))
      (.then render-checklist-success)
      (.catch render-error)))


(comment
  
  (make-checklist "dev test" ["first one", "second one", "thrid one"])
  )