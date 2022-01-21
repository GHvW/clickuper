(ns clickuper.app.main
  (:require
   ["process" :refer [argv]]
   ["commander" :refer [Command]]
   [clickuper.app.config :refer [read-config]]
   [clickuper.app.clickup-api-client :refer [make-clickup-client post-checklist]]
   [clickuper.app.checklist :refer [action-handler]]))

; steps
; get to do column
; read in checklist
; select todo item i want to add checklist to
; post checklist to clickup to do

; move to reviewing?

;(partial action-handler (partial post-checklist config clickup-client))

(defn main
  []
  (let [program (Command.)
        config (read-config)
        clickup-client (make-clickup-client config)]
    (-> program
        (.version "0.0.1"))
    (-> program
        (.command "checklist")
        (.alias "ch")
        (.argument "<task-id>", "ClickUp task id")
        (.argument "[file]", "File containing the checklist items", "checklist.txt")
        (.description "Add a checklist to a ClickUp task")
        (.action (partial action-handler (partial post-checklist config clickup-client))))
    (.parse program argv)))
  

(comment
  (get argv 0)
  (+ 2 2)
  )