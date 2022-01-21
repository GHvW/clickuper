(ns clickuper.app.main
  (:require
   ["commander" :refer (Command)]))

; steps
; get to do column
; read in checklist
; select todo item i want to add checklist to
; post checklist to clickup to do

; move to reviewing?


(defn main
  []
  (let [program (Command.)]
    (-> program
        (.version "0.0.1"))
    (-> program
        (.command "checklist")
        (.alias "ch")
        (.argument "<task-id>", "ClickUp task id")
        (.argument "[file]", "File containing the checklist items", "checklist.txt")
        (.description "Add a checklist to a ClickUp task")
        (.action (fn [task-id file]
                   (.log js/console (str "file: " file ", " "task-id: " task-id)))))
    (.parse program (.-argv js/process))))
  