(ns fuyu_mvp.components.missing-pool
  (:require [clojure.string :as string]
            [goog.style :as style]
            [goog.object :as object]
             [fuyu_mvp.components.face :as face] ))

(defn handle-drag-start [ev selection callback]
  (println "drag-start" selection)
  (callback selection))

(defn handle-drag-end [ev selection callback]
  (println "drag-end" selection)
  (callback selection))

(defn get-classes [letter selection]
  (string/join " " ["pool-item col-sm-3 col-xs-6 col-md-2" (if (= letter selection) "is-dragging" "")]))

(defn main [letters selection select-word cancel-word]
  [:div {:class "row"}
    (map (fn [letter]
          [:div { :class (get-classes letter selection)
                  :draggable true
                  :on-drag-start (fn [ev] (handle-drag-start ev letter select-word))
                  :on-drag-end (fn [ev] (handle-drag-start ev letter cancel-word))
                  :key letter}
                  [:span {} letter] [face/main "normal"]]) letters)])
