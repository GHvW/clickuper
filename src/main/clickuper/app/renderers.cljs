(ns clickuper.app.renderers
  (:require
   ["chalk" :as chalk]))


(defn render-checklist-success
  []
  (.log js/console (.magenta chalk "Checklist created successfully")))


(defn render-item-success
  []
  (.log js/console (.blue chalk "Items created successfully")))


(defn render-error
  [err] 
  (.error js/console (.red chalk (str "error sending request: " err))))