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
