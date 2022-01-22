(ns clickuper.app.clickup-api-client
  (:require
   ["axios" :as axios]))


(defn make-clickup-client
  [{token :token}]
  (.create axios 
           #js {:baseURL "https://api.clickup.com/api/v2"
                :headers #js {"Authorization" token
                              "Content-Type" "application/json"}}))


(defn build-checklist-url
  [{team-id :team-id} task-id]
  (str "/task/" task-id "/checklist?custom_task_ids=true&team_id=" team-id))


(defn build-item-url
  [checklist-id]
  (str "/checklist/" checklist-id "/checklist_item"))


(defn checklist-response-id
  [^js/Response response]
  (.. response
      -data
      -checklist
      -id))


(defn post-items
  [^js/Axios clickup-client 
   checklist-id 
   items]
  (let [item-url (build-item-url checklist-id)]
    (.all js/Promise
          (map (fn [item]
                 (.post clickup-client
                        item-url
                        (clj->js item)))
               items))))


(defn post-checklist 
  [config 
   ^js/Axios clickup-client 
   task-id 
   {name :name items :items}]
  (let [checklist-url (build-checklist-url config task-id)]
    (-> clickup-client
        (.post checklist-url #js {:name name})
        (.then (fn [^js/Respone response]
                 (post-items clickup-client 
                             (checklist-response-id response) 
                             items))))))


;; (defn post-checklist 
;;   [config 
;;    ^js/Axios clickup-client 
;;    task-id 
;;    {name :name items :items}]
;;   (let [checklist-url (build-checklist-url config task-id)]
;;     (-> clickup-client
;;         (.post checklist-url #js {:name name})
;;         (.then (fn [^js/Response response]
;;                  (let [item-url (build-item-url (.. response 
;;                                                     -data 
;;                                                     -checklist 
;;                                                     -id))]
;;                    (.all js/Promise
;;                          (map (fn [item]
;;                                 (.post clickup-client
;;                                        item-url
;;                                        (clj->js item)))
;;                               items))))))))



(comment
  (build-checklist-url {:team-id "10101"} "DEV-0001"))