(ns fuyu_mvp.components.missing-pool
  (:require [goog.style :as style]
            [goog.object :as object]))

(defn drag-start [ev]
  (println "drag-start")
  (style/setOpacity (object/get ev "target") 0.05))

(defn main [missing-letters]
  [:div {:class "row"}
    (map (fn [letter]
          [:span {:draggable true
                  :on-drag-start drag-start
                  :key letter} letter]) missing-letters)])
