(ns clickuper.app.main)

(def api-url "https://api.clickup.com/api/v2")

(defn main
  []
  (.log js/console "hello world"))