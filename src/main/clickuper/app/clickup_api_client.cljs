(ns clickuper.app.clickup-api-client
  (:require
   ["axios" :as axios]))


(defn clickup-client
  [config]
  (.create axios #js {:baseUrl "https://api.clickup.com/api/v2"
                      :headers #js {"Authorization" (config :token)
                                    "Content-Type" "application/json"}}))


(defn build-checklist-url
  [config task-id]
  (str "/task" task-id "/checklist?custom_task_ids=true&team_id=" (config :team-id)))


(defn post-checklist 
  [config task-id list-items]
  (.post axios 
         (build-checklist-url config task-id)
         (clj->js list-items)))