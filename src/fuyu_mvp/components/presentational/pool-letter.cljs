(ns fuyu_mvp.components.pool-letter
  (:require [clojure.string :as string]
            [fuyu_mvp.components.face :as face]))

(defn handle-drag-start [ev selection callback]
  (println "drag-start" selection)
  (callback selection))

(defn handle-drag-end [ev callback]
  (println "drag-end")
  (callback))

(defn get-classes [is-dragging?]
  (string/join " " ["pool-item col-sm-3 col-xs-6 col-md-2" (if is-dragging? "is-dragging" "")]))

(defn main [letter face is-dragging? select-word unselect-word]
  [:div { :class (get-classes is-dragging?)
          :draggable true
          :on-drag-start (fn [ev] (handle-drag-start ev letter select-word))
          :on-drag-end (fn [ev] (handle-drag-end ev unselect-word))
          :key letter }
    [:span letter]
    [face/main face]])
