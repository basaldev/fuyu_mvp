(ns fuyu_mvp.components.missing-pool
  (:require [goog.style :as style]
            [goog.object :as object]
             [fuyu_mvp.components.face :as face] ))

(defn drag-start [ev selection callback]
  (println "drag-start")
  (callback letter))

(defn main [letters select-word]
  [:div {:class "row"}
    (map (fn [letter]
          [:div { :class "pool-item"
                  :draggable true
                  :on-drag-start (fn [ev] (drag-start ev letter select-word))
                  :key letter}
                  [:span {} letter] [face/main "meh"]]) letters)])
