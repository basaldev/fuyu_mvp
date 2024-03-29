(ns fuyu_mvp.components.form-letter
  (:require [clojure.string :as string]
            [goog.object :as object]
            [fuyu_mvp.components.face :as face]))

(defn handle-drag-over [ev]
  (.preventDefault ev))

(defn handle-drag-enter [ev callback]
  (println "drag-enter")
  (callback))

(defn handle-drag-leave [ev callback]
  (println "drag-leave")
  (callback))

(defn handle-drop [ev callback]
  (println "drop")
  (callback))

(defn get-classes [target? hovering? letter]
  (string/join " " ["form-item" (if (string/blank? letter) "open" "") (if target? "is-target" "") (and target? (if hovering? "is-hover" "")) ]))

(defn get-style [index]
  { "animationDelay" (str (* 100 index) "ms") })

(defn main [index letter face column target? hovering? decide-word enter-form leave-form]
  [:div { :class (str "col-sm-" column) :key letter }
    [:div { :class (get-classes target? hovering? letter)
            :style (get-style index)}
      [:div { :class "drag-bucket"
              :on-drag-over handle-drag-over
              :on-drag-enter (fn [ev] (handle-drag-enter ev enter-form))
              :on-drag-leave (fn [ev] (handle-drag-leave ev leave-form))
              :on-drop (fn [ev] (handle-drop ev decide-word))}]
      [:span {} letter]
      [face/main face]]])
