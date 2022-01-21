(ns clickuper.app.config)

(defn read-config
  []
  {:token (.. js/process -env -CLICKUP_API_KEY)
   :user-id (.. js/process -env -CLICKUP_USER_ID)
   :team-id (.. js/process -env -CLICKUP_WORKSPACE_ID)})


(comment

  (.. js/process -env -CLICKUP_API_KEY)

  (read-config)
  )  