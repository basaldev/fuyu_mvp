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

(defn is-dragging [selecting? letter selection]
  (and selecting? (= letter selection)))

(defn get-classes [is-dragging?]
  (string/join " " ["pool-item col-sm-3 col-xs-6 col-md-2" (if is-dragging? "is-dragging" "")]))

(defn get-face [is-dragging? correct?]
  (if is-dragging?
    (if correct? "happy" "sad")
    "normal"))

(defn main [letters selection selecting? correct? select-word unselect-word]
  [:div {:class "row"}
    (map (fn [letter]
      (let [
        is-dragging? (is-dragging selecting? letter selection)
        face (get-face is-dragging? correct?)]
        [:div { :class (get-classes is-dragging?)
                :draggable true
                :on-drag-start (fn [ev] (handle-drag-start ev letter select-word))
                :on-drag-end (fn [ev] (handle-drag-start ev letter unselect-word))
                :key letter}
          [:span letter]
          [face/main face]])) letters)])
