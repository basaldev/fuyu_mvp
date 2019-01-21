(ns fuyu_mvp.domain.store
  (:require [reagent.core :as r]))

(def state
  (r/atom { :question (vec "こうえん")
            :options (vec "あかさたな")
            :missing 2
            :selection ""
            :selecting? false
            :hovering? false
            :answered? false
            :correct? false}))

(defn swap [key value]
  (swap! state assoc key value)
  (println "update state:" key value @state))

(defn get-question []
  (@state :question))

(defn get-options []
  (@state :options))

(defn get-missing []
  (@state :missing))

(defn get-selection []
  (@state :selection))

(defn get-selecting? []
  (@state :selecting?))

(defn get-hovering? []
  (@state :hovering?))

(defn get-answered? []
  (@state :answered?))

(defn get-correct? []
  (@state :correct?))

(defn get-answer []
  ((vec (get-question)) (get-missing)))

(defn get-result []
  (= (get-answer) (get-selection)))
